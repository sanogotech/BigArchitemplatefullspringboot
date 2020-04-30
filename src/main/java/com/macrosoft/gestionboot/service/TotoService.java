package com.macrosoft.gestionboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macrosoft.gestionboot.model.Customer;
import com.macrosoft.gestionboot.repository.CustomerRepository;

import java.util.List;

@Service("totoService")
public class TotoService implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void addCustomer(Customer customer)
    {
        customerRepository.save(customer);
    }

    public List<Customer> listCustomer()
    {
        return customerRepository.findAll();
    }

    public void deleteById(Long id)
    {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findByName(String name) {
        //return customerRepository.findByNameContainingIgnoreCase(name);
        return null;
    }

}
