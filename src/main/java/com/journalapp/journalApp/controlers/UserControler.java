package com.journalapp.journalApp.controlers;

import com.journalapp.journalApp.Repo.UserRepo;
import com.journalapp.journalApp.api.responce.WeatherResponce;
import com.journalapp.journalApp.entity.User;
import com.journalapp.journalApp.service.UserService;
import com.journalapp.journalApp.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserControler {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private WeatherService weatherService;



    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody User user){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User userInDb = userService.findByUserName(userName);

        userInDb.setUserName(user.getUserName());
        userInDb.setPassword(user.getPassword());
        userService.saveNewUser(userInDb);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping
    public ResponseEntity<?> deleteUser(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        userRepo.deleteByUserName(authentication.getName());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @GetMapping
    public ResponseEntity<?>greetings(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        WeatherResponce weatherResponce = weatherService.getWeather("Mumbai");
        String greating = "";
        if(weatherResponce != null){
            greating= "Weather Feels Like "+ weatherResponce.getCurrent().getFeelslike() + "C";
        }
        return new ResponseEntity<>("Hi"+" "+ authentication.getName()+" " + greating  , HttpStatus.OK);
    }
}
