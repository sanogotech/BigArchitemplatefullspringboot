package com.macrosoft.gestionboot.repository.customer;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macrosoft.gestionboot.model.customer.Product;
import com.macrosoft.gestionboot.model.customer.PurchaseOrder;



public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long>{
	

	List<PurchaseOrder> findByOrderLineItemList_product(Product product);
	
	
	List<PurchaseOrder> findByOrderLineItemList_Product_Madein(String madein);
	
	List<PurchaseOrder> findByCustomer_Email(String email);


}
