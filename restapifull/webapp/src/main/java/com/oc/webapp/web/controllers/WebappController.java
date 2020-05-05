package com.oc.webapp.web.controllers;

import java.util.List;

import javax.validation.Valid;

import com.oc.webapp.model.beans.AvailableCopieBean;
import com.oc.webapp.model.beans.BookBean;
import com.oc.webapp.model.beans.BorrowBean;
import com.oc.webapp.model.dto.RegisteredUserDto;
import com.oc.webapp.service.WebappService;
import com.oc.webapp.web.proxies.apiproxies.ApiProxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import feign.FeignException;

import org.springframework.web.bind.annotation.PostMapping;

/**
 * WebappController
 */
@Controller
public class WebappController {

    @Autowired
    private ApiProxy apiProxy;

    @Autowired
    private WebappService webappService;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /* @GetMapping(value = "/")
    public String mainPage() {

        logger.info("Reach url: / - GET");

        return "MainPage";
    } */

    @GetMapping(value = "/")
    public String getBooksPage(Model model, @RequestParam(required = false) String query) {

        logger.info("Reach url: /books - GET");

        if (query == null)
            query = "";

        List<BookBean> books = apiProxy.getBooks(query);
        List<AvailableCopieBean> availableCopies = apiProxy.getAvailableCopies();

        model.addAttribute("books", books);
        model.addAttribute("availableCopies", availableCopies);

        return "Books";
    }

    @GetMapping(value = "/registration")
    public String getRegistrationPage(Model model) {

        logger.info("Reach url: /registration - GET");

        model.addAttribute("user", new RegisteredUserDto());

        return "Registration";
    }

    @PostMapping(value = "/registration")
    public String registerUserAccount(@ModelAttribute("user") @Valid RegisteredUserDto accountDto, BindingResult result,
            Model model) {

        logger.info("Reach url: /registration - POST");

        ResponseEntity<Void> response = null;
        int status = 0;
        if (!result.hasErrors()) {

            try {
                response = webappService.createUser(accountDto);
                status = response.getStatusCodeValue();
            } catch (FeignException e) {
                logger.debug(e.getMessage());
                logger.debug(e.getLocalizedMessage());
                status = e.status();
                e.printStackTrace();
            }
            if (status == 400)
                result.addError(new ObjectError("emailAreadyExist",
                        "Cette adresse email est déjà liée à un compte utilisateur"));
        }

        if (result.hasErrors()) {
            model.addAttribute("user", accountDto);
            return "Registration";
        } else {
            model.addAttribute("user", accountDto);
            return "SuccesRegister";
        }

    }

    @GetMapping(value = "/connexion")
    public String getLoginPage(Model model) {

        logger.info("Reach url: /connexion - GET");

        model.addAttribute("user", new RegisteredUserDto());
        return "Login";
    }

    @GetMapping(value = "/profile")
    public String getProfilePage(Model model) {

        logger.info("Reach url: /profile - GET");

        // Get active borrows list for current user
        List<BorrowBean> currentUserActiveBorrows = webappService.getActiveBorrowsByRegisteredUserId();

        model.addAttribute("currentUserActiveBorrows", currentUserActiveBorrows);
        return "MyBorrows";
    }

    @PostMapping(value = "/profile")
    public String extendBorrowDuration(@RequestParam int borrowId) {

        logger.info("Reach url: /profile - POST");

        // Extend borrow duration
        webappService.extendBorrowDuration(borrowId);

        return "redirect:/profile";
    }

    @GetMapping(value="/disconnect")
    public String redirectLoginPageAfterLogout() {

        return "redirect:/connexion?logout=true";
    }
    

}