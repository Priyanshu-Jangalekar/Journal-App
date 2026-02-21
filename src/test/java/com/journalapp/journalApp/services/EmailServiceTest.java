package com.journalapp.journalApp.services;

import com.journalapp.journalApp.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {
    @Autowired
    private EmailService emailService;

    @Test
    void mailtester(){
        emailService.sendMail("priyanshujangalekar@gmail.com" , "Weekly Sentiment Analysis" ,"hey , mail service is working");
    }
}
