package com.macrosoft.gestionboot.service.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.macrosoft.gestionboot.model.customer.Customer;
import com.macrosoft.gestionboot.repository.customer.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService{

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
    public    List<Customer> findByName(String name) {
        return customerRepository.findByNameContainingIgnoreCase(name);

    }

}
