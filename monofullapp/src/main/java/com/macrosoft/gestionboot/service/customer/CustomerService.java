package com.macrosoft.gestionboot.service.customer;

import java.util.List;

import com.macrosoft.gestionboot.model.customer.Customer;



public interface CustomerService {

    public void addCustomer (Customer customer);

    public List<Customer> listCustomer();

    public void deleteById(Long id);

    public    List<Customer> findByName(String name);
}
