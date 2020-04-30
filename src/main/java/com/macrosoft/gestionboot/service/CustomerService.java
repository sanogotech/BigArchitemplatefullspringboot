package com.macrosoft.gestionboot.service;

import java.util.List;

import com.macrosoft.gestionboot.model.Customer;

public interface CustomerService {

    public void addCustomer (Customer customer);

    public List<Customer> listCustomer();

    public void deleteById(Long id);

    public Customer findByName(String name);
}
