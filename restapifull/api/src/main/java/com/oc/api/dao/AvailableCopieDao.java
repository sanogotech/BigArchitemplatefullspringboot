package com.oc.api.dao;

import com.oc.api.model.beans.AvailableCopie;
import com.oc.api.model.beans.AvailableCopieKey;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * AvailableCopieDao
 */
@Repository
public interface AvailableCopieDao extends JpaRepository<AvailableCopie, AvailableCopieKey>{

    
}