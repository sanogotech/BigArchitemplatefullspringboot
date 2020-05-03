package com.macrosoft.gestionboot.repository.customer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macrosoft.gestionboot.model.customer.OrderLineItem;


public interface OrderLineItemRepository  extends JpaRepository<OrderLineItem, Long>{

}
