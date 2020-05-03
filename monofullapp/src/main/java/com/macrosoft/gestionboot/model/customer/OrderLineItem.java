package com.macrosoft.gestionboot.model.customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class OrderLineItem {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderlineItemId;
	
	private long  quantity;
	
	@ManyToOne
	private PurchaseOrder purchaseOrder;
	
	@ManyToOne() 
	private Product product;

	public long getOrderlineItemId() {
		return orderlineItemId;
	}

	public void setOrderlineItemId(long orderlineItemId) {
		this.orderlineItemId = orderlineItemId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	public PurchaseOrder getPurchaseOrder() {
		return purchaseOrder;
	}

	public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
		this.purchaseOrder = purchaseOrder;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	

}
