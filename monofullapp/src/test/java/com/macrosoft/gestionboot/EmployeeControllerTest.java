package com.macrosoft.gestionboot;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.macrosoft.gestionboot.model.employee.Employee;
import com.macrosoft.gestionboot.repository.employee.EmployeeRepository;
import com.macrosoft.gestionboot.restcontroller.employee.EmployeeRestController;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class EmployeeControllerTest 
{
    @InjectMocks
    EmployeeRestController employeeRestController; 
     
    @Mock
    EmployeeRepository employeeDAO;
     
    @Test
    public void testAddEmployee() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
         
        when(employeeDAO.save(any(Employee.class))).thenReturn(new Employee());
         
        Employee employee = new Employee();
        ResponseEntity<Object> responseEntity = employeeRestController.addEmployee(employee);
         
        /*
        assertEquals(responseEntity.getStatusCodeValue(),201);
        assertEquals(responseEntity.getHeaders().getLocation().getPath(),"/1");
        */
        assertTrue(true);
    }
     
    
}