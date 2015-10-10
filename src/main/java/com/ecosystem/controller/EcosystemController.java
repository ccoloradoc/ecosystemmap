package com.ecosystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecosystem.auth.CustomAuthenticationProvider;
import com.ecosystem.model.User;
import com.ecosystem.service.UserService;

@Controller
public class EcosystemController {
	
	@Autowired
	private UserService userService;
	@Autowired
	protected CustomAuthenticationProvider authenticationManager;
	
	@RequestMapping("/")
	public String home(ModelMap model) {
		model.addAttribute("user", new User());
	   return "home";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(ModelMap model) {
	   model.addAttribute("user", new User());
	   return "about";
	}
	
	@RequestMapping(value = "/faq", method = RequestMethod.GET)
	public String faq(ModelMap model) {
	   model.addAttribute("user", new User());
	   return "faq";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(ModelMap model) {
		model.addAttribute("user", new User());
	   return "contact";
	}
	
	@RequestMapping(value = "/terms", method = RequestMethod.GET)
	public String terms(ModelMap model) {
		model.addAttribute("user", new User());
	   return "terms";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public final String displayLoginform(Model model,  @RequestParam(value = "error", required = false) final String error) {
		model.addAttribute("user", new User());
	    return "auth/login";
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String userNew(@ModelAttribute("user") User user, BindingResult result) {
		//Adding new user
		user.setActivationCode("random");
		userService.addUser(user);
		//Authenticate user
		try {
			Authentication token = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(token);
		} catch(Exception e ) {
			SecurityContextHolder.getContext().setAuthentication(null);
			e.printStackTrace();
		}
		//Redirect
		return "redirect:/admin";
	}
}
