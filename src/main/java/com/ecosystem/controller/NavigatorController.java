package com.ecosystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NavigatorController {
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
