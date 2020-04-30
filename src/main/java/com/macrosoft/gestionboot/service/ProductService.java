package com.macrosoft.gestionboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macrosoft.gestionboot.model.Product;
import com.macrosoft.gestionboot.repository.ProductRepository;


@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void addProduct(Product product)
    {
        productRepository.save(product);
    }

}
