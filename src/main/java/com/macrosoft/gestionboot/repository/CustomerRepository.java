package com.macrosoft.gestionboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macrosoft.gestionboot.model.Customer;

import java.util.List;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long> {

    List<Customer> findByNameContainingIgnoreCase(String name);
    /*
    @Query(value = "SELECT * FROM USERS u WHERE u.status = 1", nativeQuery = true)
    Collection<User> findAllActiveUsersNative();
    */

}
