package com.journalapp.journalApp.cache;

import com.journalapp.journalApp.Repo.ConfigJournalAppRepo;
import com.journalapp.journalApp.entity.ConfigJournalAppEntity;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AppCache {
    @Autowired
    private ConfigJournalAppRepo configJournalAppRepo;

    public Map<String , String>AppCache;

    @PostConstruct
    public void inti(){
        AppCache = new HashMap<>();
       List<ConfigJournalAppEntity> all = configJournalAppRepo.findAll();
       for(ConfigJournalAppEntity configJournalAppEntity : all){
           AppCache.put(configJournalAppEntity.getKey() , configJournalAppEntity.getValue());
       }
    }
}
