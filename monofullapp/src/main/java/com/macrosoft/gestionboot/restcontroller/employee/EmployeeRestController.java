package com.macrosoft.gestionboot.restcontroller.employee;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.macrosoft.gestionboot.model.employee.Employee;
import com.macrosoft.gestionboot.repository.employee.EmployeeRepository;

//https://howtodoinjava.com/spring-boot2/testing/rest-controller-unit-test-example/
 
@RestController
@RequestMapping(path = "/employees")
public class EmployeeRestController 
{
    @Autowired
    private EmployeeRepository employeeRepository;
 
    @GetMapping(path="/", produces = "application/json")
    public List<Employee> getEmployees() 
    {
        return employeeRepository.findAll();
    }
     
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Employee employee) {       
                 
        //add resource
        employeeRepository.save(employee);
         
        //**** Create resource location
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(employee.getId())
                                    .toUri();
         
        // **** Send location in response
        return ResponseEntity.created(location).build();
    }
}
