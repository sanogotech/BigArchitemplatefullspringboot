package com.macrosoft.gestionboot.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;

import com.macrosoft.gestionboot.model.employee.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
