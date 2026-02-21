package com.journalapp.journalApp.Repo;

import com.journalapp.journalApp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User , ObjectId> {
    User findByUserName(String username);
    void deleteByUserName(String Username);
}
