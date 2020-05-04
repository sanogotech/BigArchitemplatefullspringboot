package com.macrosoft.gestionboot.service.employee;

import java.util.HashMap;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.macrosoft.gestionboot.model.employee.Employee;
 
@Service
public class EmployeeManager 
{
    static HashMap<Long, Employee> db = new HashMap<>();
     
    static {
        db.put(1L, new Employee(1L, "Alex", "Gussin"));
        db.put(2L, new Employee(2L, "Brian", "Schultz"));
    }
     
    @Cacheable(cacheNames="employeeCache", key="#id")
    public Employee getEmployeeById(Long id) {
        System.out.println("Getting employee from DB");
        return db.get(id);
    }
}

