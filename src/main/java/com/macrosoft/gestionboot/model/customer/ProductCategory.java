package com.macrosoft.gestionboot.model.customer;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ProductCategory {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	 private String name;
	
	/*mappedBy indicates the entity is the inverse of the relationship.*/
	 
	 @OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL)
	 private Set<Product> products;

	 public  ProductCategory(){

	 }

	 public ProductCategory(String name) {
	        this.name = name;
	 }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	 
	
	 

}
