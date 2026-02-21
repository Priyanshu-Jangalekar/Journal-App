package com.journalapp.journalApp.Scheduler;

import com.journalapp.journalApp.Repo.UserRepoImpl;
import com.journalapp.journalApp.entity.JournalEntry;
import com.journalapp.journalApp.entity.User;
import com.journalapp.journalApp.service.EmailService;
import com.journalapp.journalApp.service.SentimentAnalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;


public class UserScheduler {
    @Autowired
    private UserRepoImpl userRepoImpl;
    @Autowired
    private EmailService emailService;
    @Autowired
    private SentimentAnalysisService sentimentAnalysisService;

    @Scheduled(cron = "0 0 9 * * SUN")
    public void featchAndSendSaMail(){
        List<User> users =userRepoImpl.getUserForSA();
        for(User user:users){
            List<JournalEntry>journalEntries = user.getJournalEntries();
            List<String>filterdEntries = journalEntries.stream().filter(x->x.getDate().isAfter(LocalDateTime.now().minus(7, ChronoUnit.DAYS))).map(x->x.getContent()).collect(Collectors.toList());
            String entry = String.join("" , filterdEntries);
            String sentiment = sentimentAnalysisService.getsentiment(entry);
            emailService.sendMail(user.getEmail() , "Weekly sentimet Analysis" , sentiment);
        }
    }
}
