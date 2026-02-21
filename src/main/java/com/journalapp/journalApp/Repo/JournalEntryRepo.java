package com.journalapp.journalApp.Repo;

import com.journalapp.journalApp.entity.JournalEntry;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JournalEntryRepo extends MongoRepository<JournalEntry , ObjectId> {
}
