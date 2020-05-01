package com.macrosoft.gestionboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	
	
	@GetMapping("/")
	public String indexpage() {

		return "index";
	}
	

	
	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public String loginGet(@RequestParam(value = "error", required = false)String error) {

		return "login";
	}
	
	


	
	 @GetMapping("/home")
	    public String home(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
	        model.addAttribute("name", name);
	        //log.info("Call home page");
	        return "home";
	    }


}
