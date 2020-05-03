package com.macrosoft.gestionboot.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.macrosoft.gestionboot.model.customer.Product;
import com.macrosoft.gestionboot.service.customer.ProductServiceImpl;


@Controller
public class ProductCrudAppController {

	@Autowired
	private ProductServiceImpl service; 
	
	//  search/javaterm
	@RequestMapping(value="/search/{searchTerm}")
	public ModelAndView searchpath(@PathVariable("searchTerm") String pSearchTerm) {
	    ModelAndView mav = new ModelAndView("search");

	    mav.addObject("searchTerm", pSearchTerm);
	    //mav.addObject("searchResult", sp.findTeamByName(pSearchTerm));   
	    
	    //TODO

	    return mav;
	}
	
	//  search?searchTerm=java 
	@RequestMapping(value="/searchbyname")
	public String searchparam(@RequestParam(value = "searchTerm", required = false) String pSearchTerm, Model model) {
	   
		List<Product> listProducts = service.searchByNameIgnoreCase(pSearchTerm);
		model.addAttribute("listProducts", listProducts);
		
		return "crudindex";
	}
	
	@RequestMapping("/crudindex")
	public String viewHomePage(Model model) {
		List<Product> listProducts = service.listAll();
		model.addAttribute("listProducts", listProducts);
		
		return "crudindex";
	}
	
	@RequestMapping("/crudnew")
	public String showNewProductPage(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);
		
		return "new_product";
	}
	
	@RequestMapping(value = "/crudsave", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute("product") Product product) {
		service.save(product);
		
		return "redirect:/crudindex";
	}
	
	@RequestMapping("/crudedit/{id}")
	public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("edit_product");
		Product product = service.get(id);
		mav.addObject("product", product);
		
		return mav;
	}
	
	@RequestMapping("/cruddelete/{id}")
	public String deleteProduct(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/crudindex";		
	}
}
