package com.ecosystem.auth.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.ecosystem.model.User;
import com.ecosystem.service.UserService;

public class AuthenticationProviderService implements AuthenticationProvider, AuthenticationSuccessHandler {

	@Autowired
	private UserService userService;
	
	/*AuthenticationProvider*/
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String name = auth.getName();
        String password = auth.getCredentials().toString();
        
        User user = userService.findByEmail(name);
        
        //Account does not exist
        if(user == null) {
        	throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
        }
        
        if (user.getEmail().equals(name) && user.getPassword().equals(password)) {
        	//Account has not been activated
        	if(user.getEnabled() == 0) {
        		throw new DisabledException("Accoun has not been validated");
        	}
        	
            List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            Authentication token = new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
            return token;
        }
        
        //Account password incorrect
        throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
	}

	public boolean supports(Class<?> auth) {
		// TODO Auto-generated method stub
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(auth));
	}

	/*AuthenticationSuccessHandler*/
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
        HttpSession session = request.getSession();  
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails)principal).getUsername();    
        } else {
        	username = principal.toString();
        }
        
        User user = userService.findByEmail(username);
        
        session.setAttribute("display_name", user.getUsername());
        
        //set our response to OK status  
        response.setStatus(HttpServletResponse.SC_OK);  
  
        //since we have created our custom success handler, its up to us to where  
        //we will redirect the user after successfully login  
        response.sendRedirect(request.getContextPath() + "/");  
        
	}
	
}
