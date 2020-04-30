package com.macrosoft.gestionboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macrosoft.gestionboot.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
