package com.oc.api.manager.impl;

import com.oc.api.manager.UtilsManager;

import org.springframework.stereotype.Service;

/**
 * UtilsManagerImpl
 * 
 * This class is toolbox, it contains utilitary methods
 * 
 */
@Service
public class UtilsManagerImpl implements UtilsManager {

    /**
     * Split String query when space is detected, return String Table.
     * @param query
     */
    @Override
    public String[] splitQueryString(String query) {

        String[] splitedQueries = query.split(" ");

        return splitedQueries;

    }
  
}