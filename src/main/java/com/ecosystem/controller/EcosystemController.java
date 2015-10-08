package com.ecosystem.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EcosystemController {
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about() {
	   return "about";
	}
	
	@RequestMapping(value = "/faq", method = RequestMethod.GET)
	public String faq() {
	   return "faq";
	}
	
	@RequestMapping(value = "/contact", method = RequestMethod.GET)
	public String contact() {
	   return "contact";
	}
	
	@RequestMapping(value = "/terms", method = RequestMethod.GET)
	public String terms() {
	   return "terms";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public final String displayLoginform(Model model,  @RequestParam(value = "error", required = false) final String error) {
	    model.addAttribute("error", error);
	    return "auth/login";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout() {
	   return "auth/logout";
	}
	
	private String getPrincipal(){
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
 
        if (principal instanceof UserDetails) {
            userName = ((UserDetails)principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }
}
