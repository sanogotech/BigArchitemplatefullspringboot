package com.oc.batch.service.impl;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

import com.oc.batch.model.beans.BorrowBean;
import com.oc.batch.service.EmailService;
import com.oc.batch.web.proxies.ApiProxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * EmailServiceImpl
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private ApiProxy apiProxy;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     *  Send email to users which have late borrows every day
     */
    @Scheduled(cron = "${batch.time.event}")
    public void sendMailForLateBorrowsEveryDay() {

        logger.info("Sending emails for late borrows");

        // Get borrows list
        List<BorrowBean> borrows = apiProxy.getBorrows();

        // Init today date
        LocalDate today = LocalDate.now();

        for (BorrowBean borrowBean : borrows) {

            // Filter active and late borrows
            if (borrowBean.getReturnDate().isBefore(today) && !borrowBean.getBookReturned()) {

                // Generate mail for current borrow
                HashMap<String, String> mailData = generateLateBorrowsEmail(borrowBean);

                // Send mail for current borrow
                sendSimpleMessage(mailData.get("to"), mailData.get("subject"), mailData.get("text"));
            }
        }
    }

    /**
     * Generate mail data according to borrow data, return "to", "subject" and
     * "text" parameters
     * @param lateBorrow
     */
    private HashMap<String, String> generateLateBorrowsEmail(BorrowBean lateBorrow) {

        logger.debug("Generating mail data for late borrow, id:" + lateBorrow.getId());
        // Init new line
        String newLine = System.getProperty("line.separator");
        // Init HashMap witch will contains mail data
        HashMap<String, String> mailData = new HashMap<>();
        // Extract data from borrow bean
        String title = lateBorrow.getBook().getTitle();
        String library = lateBorrow.getLibrary().getName();
        // Build "to" parameter
        String to = lateBorrow.getRegistereduser().getEmail();
        // Build "subject" parameter
        String subject = "Date de retour dépassée du livre " + title;
        // Build "text" parameter
        String text = "L'emprunt du livre \"" + title + "\""
                + " a dépassé sa date d'échéance, veuillez nous ramener le livre à la bibliothèque de " + library
                + " dans les plus brefs délais." + newLine + "Cordialement." + newLine + "OC-Bibliothèque.";
        // Fill Hashmap with data
        mailData.put("to", to);
        mailData.put("subject", subject);
        mailData.put("text", text);

        return mailData;

    }

    public void sendSimpleMessage(String to, String subject, String text) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(text);

            emailSender.send(message);
        } catch (MailException exception) {
            exception.printStackTrace();
        }

    }

}