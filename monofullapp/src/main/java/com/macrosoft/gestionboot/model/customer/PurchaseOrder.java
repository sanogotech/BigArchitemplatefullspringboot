package com.macrosoft.gestionboot.model.customer;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class PurchaseOrder {
	
	//@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
   // private long id;
	
	@Id
	//@Column(unique = true)
	private String orderNumber;
	
	@Column(columnDefinition = "TIMESTAMP") 
	private
	LocalDateTime orderDateTime;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Customer customer;
	

	@OneToMany(fetch = FetchType.EAGER, mappedBy =  "purchaseOrder")
	private List<OrderLineItem>   orderLineItemList;
	
	//Default
	public PurchaseOrder (){
		
	}
	
	

	public PurchaseOrder(String orderNumber, LocalDateTime orderDateTime, Customer customer,
			List<OrderLineItem> orderLineItemList) {
		super();
		this.orderNumber = orderNumber;
		this.orderDateTime = orderDateTime;
		this.customer = customer;
		this.orderLineItemList = orderLineItemList;
	}



	

	public List<OrderLineItem> getOrderLineItemList() {
		return orderLineItemList;
	}

	public void setOrderLineItemList(List<OrderLineItem> orderLineItemList) {
		this.orderLineItemList = orderLineItemList;
	}

	public LocalDateTime getOrderDateTime() {
		return orderDateTime;
	}

	public void setOrderDateTime(LocalDateTime orderDateTime) {
		this.orderDateTime = orderDateTime;
	}



	public String getOrderNumber() {
		return orderNumber;
	}



	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}



	public Customer getCustomer() {
		return customer;
	}



	public void setCustomer(Customer customer) {
		this.customer = customer;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((orderDateTime == null) ? 0 : orderDateTime.hashCode());
		result = prime * result + ((orderLineItemList == null) ? 0 : orderLineItemList.hashCode());
		result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PurchaseOrder other = (PurchaseOrder) obj;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (orderDateTime == null) {
			if (other.orderDateTime != null)
				return false;
		} else if (!orderDateTime.equals(other.orderDateTime))
			return false;
		if (orderLineItemList == null) {
			if (other.orderLineItemList != null)
				return false;
		} else if (!orderLineItemList.equals(other.orderLineItemList))
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "PurchaseOrder [orderNumber=" + orderNumber + ", orderDateTime=" + orderDateTime + ", customer="
				+ customer + ", orderLineItemList=" + orderLineItemList + "]";
	}
	
	
	

}
