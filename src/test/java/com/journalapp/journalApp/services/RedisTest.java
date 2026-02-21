package com.journalapp.journalApp.services;

import org.bson.types.ObjectId;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testreddis(){
        redisTemplate.opsForValue().set("email" , "email@gmail.com");
        Object mail = redisTemplate.opsForValue().get("email");
    }
}
