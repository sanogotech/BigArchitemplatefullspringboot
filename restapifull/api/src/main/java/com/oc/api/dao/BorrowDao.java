package com.oc.api.dao;

import java.util.List;

import com.oc.api.model.beans.Borrow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * BorrowDao
 */
@Repository
public interface BorrowDao extends JpaRepository<Borrow, Integer>{

    List<Borrow> findByRegistereduserId(int userId);
}