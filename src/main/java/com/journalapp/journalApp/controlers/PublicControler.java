package com.journalapp.journalApp.controlers;

import com.journalapp.journalApp.Utils.JwtUtil;
import com.journalapp.journalApp.entity.User;
import com.journalapp.journalApp.service.UserDetailsServiceImpl;
import com.journalapp.journalApp.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/public")
public class PublicControler {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signup")
    public void signup(@RequestBody User user){
        userService.saveNewUser(user);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user){
       try{
           authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName() , user.getPassword()));
           UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());
           String jwt = jwtUtil.generateToken(userDetails.getUsername());
           return new ResponseEntity<>(jwt , HttpStatus.OK);
       }catch (Exception e){
           log.error("NOT Found" + e);
           return new ResponseEntity<>("Incorrect UserName or Password" , HttpStatus.NOT_FOUND);
       }
    }
    @GetMapping("/users")
    public List<User> getAllUser(){
        return userService.getAll();
    }

}
