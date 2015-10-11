package com.ecosystem.controller;

import java.util.UUID;

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
public class EcosystemController {
	
	@RequestMapping("/")
	public String home(ModelMap model) {
	   return "home";
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(ModelMap model) {
	   return "about";
	}
	
	@RequestMapping(value = "/faq", method = RequestMethod.GET)
	public String faq(ModelMap model) {
	   return "faq";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact(ModelMap model) {
	   return "contact";
	}
	
	@RequestMapping(value = "/terms", method = RequestMethod.GET)
	public String terms(ModelMap model) {
	   return "terms";
	}
	
}
