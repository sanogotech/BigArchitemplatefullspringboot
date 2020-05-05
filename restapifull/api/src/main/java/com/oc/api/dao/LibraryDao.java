package com.oc.api.dao;

import com.oc.api.model.beans.Library;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * LibraryDao
 */
@Repository
public interface LibraryDao extends JpaRepository<Library, Integer> {

}