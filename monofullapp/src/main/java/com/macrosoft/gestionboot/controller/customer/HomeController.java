package com.macrosoft.gestionboot.controller.customer;

import java.security.Principal;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	 private final Logger log = LoggerFactory.getLogger(this.getClass());
	 
	 @Autowired
	 private JdbcUserDetailsManager jdbcUserDetailsManager;
	
	
	@GetMapping("/")
	public String indexpage() {

		return "index";
	}
	

	
	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public String loginGet(@RequestParam(value = "error", required = false)String error) {

		return "loginpage";
	}
	
	


	
	 @GetMapping("/home")
	    public String home(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model,Authentication auth,Principal principal) {
	        model.addAttribute("name", name);
	        log.debug("Principal "+ principal.getName());
	        String username = auth.getName();
	      //  String password = auth.getCredentials().toString();
	        Collection<? extends GrantedAuthority> authoritiesList =auth.getAuthorities();
	        log.debug("*** Username :" + username );
	        
	        //
	        UserDetails userDetails = jdbcUserDetailsManager.loadUserByUsername(username);
	        log.debug("*** UserDetails From DB Password :" + userDetails.getPassword() );
	        return "home";
	    }


}
