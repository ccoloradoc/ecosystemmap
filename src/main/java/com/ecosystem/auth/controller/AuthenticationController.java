package com.ecosystem.auth.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecosystem.auth.service.AuthenticationProviderService;
import com.ecosystem.model.User;
import com.ecosystem.service.UserService;
import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private VelocityEngine velocityEngine;
	
	@Autowired
	protected AuthenticationProviderService authenticationManager;
	
	@Autowired
	SendGrid sendGridService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public final String displayLoginform(Model model,  @RequestParam(value = "error", required = false) final String error) {
		model.addAttribute("user", new User());
	    return "auth/login";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String userNew(@ModelAttribute("user") User user, BindingResult result, ModelMap model) {
		//User already exist in database
		if(userService.findByEmail(user.getEmail()) != null) {
			return displayInformation(model, "DUPLICATE_USER_ERROR"); //Recover password
		}
		//Adding new user
		user.resetActivationCode();
		userService.addUser(user);
		
		//Sending user email
		sendValidationEmail(user);
		
		model.addAttribute("information", "We have sent you a new token thru email!");
		return "auth/token_recovery";
	}
	
	
	
	@RequestMapping(value="/validate/{userId}", method = RequestMethod.GET) 
	public String validate(@PathVariable Integer userId, @RequestParam("t") String validationToken, ModelMap model) {
		User user = userService.find(userId);
		
		//User does not exist
		if(user == null) {
			model.addAttribute("information", "Your token has expired, you can request new token to be sent here.");
			return "auth/token_recovery";
		}
		
		user.setPassword("");
		user.setActivationCode(validationToken);
		
		model.addAttribute("validateUser", user);
		return "auth/validation";
	}
	
	@RequestMapping(value="/validate", method = RequestMethod.POST) 
	public String validate(@ModelAttribute User user, ModelMap model, HttpSession session) {
		String view = "redirect:/";
		try { 
			Authentication token = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(token);
			model.addAttribute("display_name", user.getUsername());
		} catch(BadCredentialsException e ) {
			model.addAttribute("validateUser", user);
			model.addAttribute("error", "Username/Password does not match.");
			view = "auth/validation";
		} catch(DisabledException e) {
			User dbUser = userService.findByEmail(user.getEmail());
			//Activate
			if(!dbUser.getActivationCode().equalsIgnoreCase(user.getActivationCode())) {
				model.addAttribute("information", "Your token has expired, you can request new token to be sent here.");
				view = "auth/token_recovery";  //Recover validation token
			} else {
				//Enable user
				dbUser.setEnabled(1);
				userService.updateUser(dbUser);
				//Authenticate
				Authentication token = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
				SecurityContextHolder.getContext().setAuthentication(token);
				session.setAttribute("display_name", dbUser.getUsername());
			}
		} 
		//Redirect
		return view;
	}
	
	@RequestMapping(value="/token_recovery", method = RequestMethod.POST)
	public String tokenRecovery(@RequestParam(value = "email", required = false) final String email, ModelMap model) {
		User user = userService.findByEmail(email);
		
		if(user == null) {
			model.addAttribute("error", "We are sorry! Your user is not register on our database.");
			return "auth/token_recovery";
		}
		
		user.resetActivationCode();
		userService.updateUser(user);
		
		//Sending user email
		sendValidationEmail(user);
		
		model.addAttribute("information", "We have sent you a new token thru email!");
		return "auth/token_recovery";
	}
	
	public String displayInformation(ModelMap model, String info) {
		System.out.println(">> " + info);
		model.addAttribute(info, "active");
	    return "auth/info";
	}
	
	private void sendValidationEmail(User user) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("username", user.getUsername());
		paramMap.put("activation_url", "http://ecosystemmap.co/auth/validate/"+ user.getUserId() + "?t=" + user.getActivationCode());
		
		
        String text = VelocityEngineUtils.mergeTemplateIntoString(this.velocityEngine, "activation.html", "UTF-8", paramMap);
        
		
		//Send confirmation email 
	    SendGrid.Email email = new SendGrid.Email();

	    email.addTo(user.getEmail());
	    email.setFrom("support@ecosystemmap.co");
	    email.setSubject("Welcome To Ecosystem Map! Confirm Your Email");
	    email.setHtml(text);
	    
	    try {
			SendGrid.Response response = sendGridService.send(email);
		} catch (SendGridException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
