package com.macrosoft.gestionboot.form;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.macrosoft.gestionboot.model.customer.Product;
import com.macrosoft.gestionboot.service.customer.ProductService;

/**
 * WebController est la classe qui permet de valider un formulaire
 */

@Controller
public class WebController implements WebMvcConfigurer {

    @Autowired
    private ProductService productService;

    // Voici comment instancier un Logger
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/productresults").setViewName("productresults");
    }

    /**
     * ShowForm permet d'afficher le formulaire d'ajout de produit
     * @param productForm: represente le formulaire qui contient (le nom, le numéro, le prix et la description)
     * @return le lien vers la page de création des produits
     */
    @GetMapping("/add-product")
    public String showForm(ProductForm productForm) {
        log.info("Call add product form page");
        return "myproduct";
    }

    @PostMapping("/add-product")
    public String checkProductInfo(@Valid ProductForm productForm, BindingResult bindingResult) {
        log.info("Check product information method");

        if (bindingResult.hasErrors()) {
            return "myproduct";
        }

        Product product = new Product();

        product.setNumberProduct(productForm.getNumberProduct());

        product.setName(productForm.getName());

        product.setPrice(productForm.getPrice());

        product.setDescription(productForm.getDescription());

        productService.save(product);

        return "redirect:/productresults";
    }

}
