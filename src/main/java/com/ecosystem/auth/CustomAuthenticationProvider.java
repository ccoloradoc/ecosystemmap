package com.ecosystem.auth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

public class CustomAuthenticationProvider implements AuthenticationProvider, AuthenticationSuccessHandler {

	/*AuthenticationProvider*/
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		String name = auth.getName();
        String password = auth.getCredentials().toString();
        
        System.out.println(">>>Name: " +  name + " - password:" + password);
        
        if (name.equals("admin") && password.equals("system")) {
            List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            Authentication token = new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
            return token;
        }
        
        if (name.equals("audrey") && password.equals("hepburn")) {
            List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
            grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));
            Authentication token = new UsernamePasswordAuthenticationToken(name, password, grantedAuths);
            return token;
        }
        
        throw new BadCredentialsException("Username/Password does not match for " + auth.getPrincipal());
	}

	public boolean supports(Class<?> auth) {
		// TODO Auto-generated method stub
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(auth));
	}

	/*AuthenticationSuccessHandler*/
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication) throws IOException,
			ServletException {
		//do some logic here if you want something to be done whenever  
        //the user successfully logs in.  
  
        HttpSession session = request.getSession();  
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        
        if (principal instanceof UserDetails) {
            session.setAttribute("username", ((UserDetails)principal).getUsername());  
            session.setAttribute("authorities", ((UserDetails)principal).getAuthorities());  
      
        } else {
        	session.setAttribute("username", principal.toString());
        }
        
        request.setAttribute("message", "");
        
        //set our response to OK status  
        response.setStatus(HttpServletResponse.SC_OK);  
  
        //since we have created our custom success handler, its up to us to where  
        //we will redirect the user after successfully login  
        response.sendRedirect(request.getContextPath() + "/");  
        
	}
	
}
