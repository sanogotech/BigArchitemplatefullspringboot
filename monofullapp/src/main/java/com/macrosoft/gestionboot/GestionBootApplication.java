package com.macrosoft.gestionboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//Cache
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;


import com.macrosoft.gestionboot.service.employee.EmployeeManager;

@SpringBootApplication
public class GestionBootApplication  implements CommandLineRunner{
	
	@Autowired
	private CacheManager cacheManager;
	     
	@Autowired
	private EmployeeManager employeeManager;

	public static void main(String[] args) {
		SpringApplication.run(GestionBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//This will hit the database 
        System.out.println(employeeManager.getEmployeeById(1L));
         
        //This will hit the cache - verify the message in console output 
        System.out.println(employeeManager.getEmployeeById(1L));
         
        //Access cache instance by name
        Cache cache = cacheManager.getCache("employeeCache");
         
        //Add entry to cache
        cache.put(3L, "Hello");
         
        //Get entry from cache
        System.out.println(cache.get(3L).get());
		
	}
	

}
