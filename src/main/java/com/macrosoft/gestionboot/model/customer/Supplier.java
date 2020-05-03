package com.macrosoft.gestionboot.model.customer;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Supplier {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long supId;
	
	String  supName;
    String  email;
    String phone;
	
	
	@OneToMany
	private List<Product>  productList;


	public long getSupId() {
		return supId;
	}


	public void setSupId(long supId) {
		this.supId = supId;
	}


	public String getSupName() {
		return supName;
	}


	public void setSupName(String supName) {
		this.supName = supName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public List<Product> getProductList() {
		return productList;
	}


	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	
	

}
