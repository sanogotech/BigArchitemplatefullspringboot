package com.macrosoft.gestionboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.macrosoft.gestionboot.form.CustomerForm;
import com.macrosoft.gestionboot.model.Customer;
import com.macrosoft.gestionboot.service.CustomerService;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
public class CustomerController implements WebMvcConfigurer {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CustomerService defaultService;
    /*
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/customers").setViewName("customers");
    }
    */

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("/customers")
    public String listCustomer(Model model)
    {
        model.addAttribute("customers", defaultService.listCustomer());

        return "customers";
    }

    @GetMapping("/add-customer")
    public String showForm(CustomerForm customerForm, Principal principal) {
        log.debug("L'utilisateur connecté est :" + principal.getName());
        return "addcustomer";
    }

    @PostMapping("/add-customer")
    public String storeCustomerInfo(@Valid CustomerForm customerForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "addcustomer";
        }

        Customer customer = new Customer();

        customer.setName(customerForm.getName());

        customer.setEmail(customerForm.getEmail());

        customer.setPhone(customerForm.getPhone());

        customer.setLocation(customerForm.getLocation());

        defaultService.addCustomer(customer);

        return "redirect:/customers";
    }

    @GetMapping("/delete-customer/{id}")
    public String deleteCustomer(@PathVariable("id") long id, Model model)
    {
        defaultService.deleteById(id);

        return "redirect:/customers";
    }

    @GetMapping("/search-customer")
    public String searchCustomer() {

        return "searchForm";
    }

    @PostMapping("/search-customer")
    public String searchCustomer(String name, Model model) {

        Customer customers = defaultService.findByName(name);

        model.addAttribute("result", customers);

        return "searchResults";
    }
}
