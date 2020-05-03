package com.macrosoft.gestionboot.model.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ShippingInfo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long  shipCustId;
	
	
    private String street;
    private String city;
    private String state;
    private String zip;
    
	public long getShipCustId() {
		return shipCustId;
	}
	public void setShipCustId(long shipCustId) {
		this.shipCustId = shipCustId;
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
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
    
    

}
