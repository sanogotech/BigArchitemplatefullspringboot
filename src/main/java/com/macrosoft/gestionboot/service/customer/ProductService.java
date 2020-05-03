package com.macrosoft.gestionboot.service.customer;

import java.util.List;

import com.macrosoft.gestionboot.model.customer.Product;



public interface ProductService {
	
	public List<Product> listAll();
	
	public List<Product> searchByName(String name);
	
	public List<Product> searchByNameIgnoreCase(String name);
	
	
	public void save(Product product);
	
	public Product get(long id);
	
	public void delete(long id);
}
