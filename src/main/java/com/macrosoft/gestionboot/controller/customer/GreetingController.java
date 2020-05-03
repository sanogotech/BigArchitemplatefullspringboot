package com.macrosoft.gestionboot.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.macrosoft.gestionboot.form.ProductBean;

@Controller
public class GreetingController {

    @GetMapping("/add-product-handling")
    public String productHandlingForm(Model model)
    {
        model.addAttribute("product", new ProductBean());
        return "myhandlingproduct";
    }

    @PostMapping("/add-product-handling")
    public String greetingSubmit(@ModelAttribute ProductBean product) {
        return "handlingresult";
    }

}
