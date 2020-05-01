package com.macrosoft.gestionboot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class UserController {
	
	@Autowired
	JdbcUserDetailsManager jdbcUserDetailsManager;
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
	    ModelAndView modelAndView = new ModelAndView();
	    //User Spring Security
	    User user = new User("","",null);
	    modelAndView.addObject("user", user);
	    modelAndView.setViewName("registration");
	    
	    return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
	    ModelAndView modelAndView = new ModelAndView();
	    
	    
	    jdbcUserDetailsManager.createUser(user);
	    modelAndView.setViewName("login");
	       
	    return modelAndView;
	}

}
