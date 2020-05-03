package com.macrosoft.gestionboot.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macrosoft.gestionboot.model.customer.ProductCategory;



public interface ProductCategoryRepository   extends JpaRepository<ProductCategory, Long> {

}
