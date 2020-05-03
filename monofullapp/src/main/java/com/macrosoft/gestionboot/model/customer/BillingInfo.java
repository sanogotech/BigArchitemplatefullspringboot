package com.macrosoft.gestionboot.model.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BillingInfo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long billInfoId;

	private String street;
	private String city;
	private String state;
	public long getBillInfoId() {
		return billInfoId;
	}
	public void setBillInfoId(long billInfoId) {
		this.billInfoId = billInfoId;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	

}
