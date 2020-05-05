package com.oc.webapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.oc.webapp.model.beans.BorrowBean;
import com.oc.webapp.model.beans.RegisteredUserBean;
import com.oc.webapp.model.dto.RegisteredUserDto;
import com.oc.webapp.security.UserPrincipal;
import com.oc.webapp.service.WebappService;
import com.oc.webapp.web.proxies.apiproxies.ApiProxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * WebappServiceImpl
 */
@Service
public class WebappServiceImpl implements WebappService {

    @Autowired
    private ApiProxy apiProxy;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Create Registered user bean with user input, call proxy api method to
     * register new user
     */
    @Override
    public ResponseEntity<Void> createUser(RegisteredUserDto accountDto) {

        logger.debug("Creating RegisteredUserBean for registration");

        // Create new RegisteredUserBean
        RegisteredUserBean registered = new RegisteredUserBean();

        // Fill it with user input
        registered.setFirstName(accountDto.getFirstName());
        registered.setLastName(accountDto.getLastName());
        registered.setEmail(accountDto.getEmail());
        registered.setPassword(accountDto.getPassword());
        registered.setRoles("USER");

        // Call api proxy method to register new user
        return apiProxy.addRegisteredUser(registered);
    }

    /**
     * Extract RegisteredUserBean from authenticated userPrincipal to return user id
     */
    @Override
    public int getAuthenticatedRegisteredUserId() {

        logger.debug("Getting authenticated current user id");

        // Get authentification context
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // Get Authenticated userPrincipal
        UserPrincipal authenticatedUser = (UserPrincipal) authentication.getPrincipal();

        // Get user id
        int authenticatedRegisteredUserId = authenticatedUser.getUserPrincipal().getId();
        return authenticatedRegisteredUserId;
    }

    /**
     * Extend duration for the target borrow
     */
    @Override
    public ResponseEntity<Void> extendBorrowDuration(int borrowId) {

        logger.debug("Extending Borrow bean duration");

        // Get borrow data
        BorrowBean extendedBorrow = new BorrowBean();
        extendedBorrow = apiProxy.getBorrowById(borrowId);

        // Create updated borrow bean
        BorrowBean updatedBorrow = extendedBorrow;

        // Add 4 weeks to return date
        updatedBorrow.setReturnDate(extendedBorrow.getReturnDate().plusWeeks(4));

        // Set true extended duration attribute
        updatedBorrow.setExtendedDuration(true);

        // Update database
        return apiProxy.updateBorrow(updatedBorrow.getId(), updatedBorrow);

    }

    /**
     * Get active borrows (bookReturned = false) for current authenticated user
     */
    @Override
    public List<BorrowBean> getActiveBorrowsByRegisteredUserId() {

        logger.debug("Getting active borrows for current authenticated user");

        // Get authenticated user id
        int authenticatedUserId = getAuthenticatedRegisteredUserId();

        // Init currentUserActiveBorrows list
        List<BorrowBean> currentUserActiveBorrows = new ArrayList<>();

        // Get list of borrows by user id
        List<BorrowBean> authenticatedUserBorrows = apiProxy.getBorrowsByUserId(authenticatedUserId);

        // Record only active borrows in currentUserActiveBorrows list
        for (BorrowBean borrowBean : authenticatedUserBorrows) {
            if (!borrowBean.getBookReturned()) {
                currentUserActiveBorrows.add(borrowBean);
            }
        }

        return currentUserActiveBorrows;
    }

}