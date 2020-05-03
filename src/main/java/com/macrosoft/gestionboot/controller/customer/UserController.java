package com.macrosoft.gestionboot.controller.customer;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.macrosoft.gestionboot.form.UserForm;

@Controller
public class UserController {
	
	@Autowired
	JdbcUserDetailsManager jdbcUserDetailsManager;
	

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
	    ModelAndView modelAndView = new ModelAndView();
	    //User Spring Security

	    UserForm userform = new UserForm();
	    modelAndView.addObject("userform", userform);
	    modelAndView.setViewName("registration");
	    
	    return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid UserForm userform, BindingResult bindingResult) {
	    ModelAndView modelAndView = new ModelAndView();
	    
	    String username = userform.getUsername();
	    String password = userform.getPassword();
	    List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        
        User userDetails = new User(username, bCryptPasswordEncoder.encode(password), authorities);
       
       
	    jdbcUserDetailsManager.createUser(userDetails);
	    modelAndView.setViewName("login");
	       
	    return modelAndView;
	}

}
