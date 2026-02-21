package com.journalapp.journalApp.controlers;

import com.journalapp.journalApp.cache.AppCache;
import com.journalapp.journalApp.entity.User;
import com.journalapp.journalApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminControler {
    @Autowired
    private UserService userService;
    @Autowired
    private AppCache appCache;

    @GetMapping("/all-users")
    public ResponseEntity<?> getallusers(){
        List<User>all =userService.getAll();
        if(!all.isEmpty() && all != null){
            return new ResponseEntity<>(all , HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/create-admin")
    public void saveadmin(@RequestBody User user){
       userService.saveAdmin(user);
    }
    @GetMapping("clear-cache")
    public void clearCache(){
        appCache.inti();
    }
}
