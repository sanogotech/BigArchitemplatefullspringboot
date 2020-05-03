package com.macrosoft.gestionboot;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.macrosoft.gestionboot.model.customer.Customer;
import com.macrosoft.gestionboot.service.customer.CustomerService;

@SpringBootTest
class GestionstocksApplicationTests {

	@Autowired
	public CustomerService defaultService;

	//@Test
	void test_get_all_customers()
	{
		// Step 1 : Init param
		// Step 2 : Call Service with parameter
		// Step 3 : Save response
		// Step 3 : assert
		List<Customer> customers = defaultService.listCustomer();

		int customerNumber = defaultService.listCustomer().size();

		assertTrue(customerNumber > 0);
	}

	//@Test
	void insert_customer_in_database()
	{
		List<Customer> customers = defaultService.listCustomer();

		Customer customer = new Customer();

		customer.setName("Diarra Mamadou");

		customer.setEmail("Test2@gmail.com");

		customer.setLocation("Location ");

		customer.setPhone("09876543");

		customer.setFileName("file.jpg");

		defaultService.addCustomer(customer);

		int customerNumber = defaultService.listCustomer().size();

		//assertThat(customers).hasSize(customerNumber);
	}

}
