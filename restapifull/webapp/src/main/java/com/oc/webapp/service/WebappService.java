package com.oc.webapp.service;

import java.util.List;

import com.oc.webapp.model.beans.BorrowBean;
import com.oc.webapp.model.dto.RegisteredUserDto;
import org.springframework.http.ResponseEntity;

/**
 * WebappService
 */
public interface WebappService {

    ResponseEntity<Void> createUser(RegisteredUserDto accountDto);

    int getAuthenticatedRegisteredUserId();

    ResponseEntity<Void> extendBorrowDuration(int borrowId);

    List<BorrowBean> getActiveBorrowsByRegisteredUserId();
}