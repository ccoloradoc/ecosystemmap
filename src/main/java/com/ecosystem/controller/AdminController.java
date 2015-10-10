package com.ecosystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ecosystem.model.User;
import com.ecosystem.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String index(ModelMap model) {
		List <User> userList = userService.getUserList();
		model.addAttribute("user", new User());
		model.addAttribute("userList", userList);
		
	   return "admin/home";
	}	
	
	@RequestMapping(value="/user/new", method = RequestMethod.POST)
	public String userNew(@ModelAttribute("user") User user, BindingResult result) {
		user.setPassword("unknown");
		user.setActivationCode("unknown");
		userService.addUser(user);
		return "redirect:/admin";
	}
	
	@RequestMapping(value="/user/delete/{userId}", method = RequestMethod.GET)
	public String userNew(@PathVariable("userId") Integer userId) {
		userService.removeUser(userId);
		return "redirect:/admin";
	}
	
	@RequestMapping(value="user/{userId}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable Integer userId) {
		User u = userService.find(userId);
		return u;
	}
	
}
