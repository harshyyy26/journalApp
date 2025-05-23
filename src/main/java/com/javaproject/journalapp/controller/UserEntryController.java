package com.javaproject.journalapp.controller;

import com.javaproject.journalapp.entity.JournalEntry;
import com.javaproject.journalapp.entity.User;
import com.javaproject.journalapp.repository.UserRepository;
import com.javaproject.journalapp.service.JournalEntryService;
import com.javaproject.journalapp.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserEntryController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping
    public void createUser(@RequestBody User user){
        userService.saveEntry(user);
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<?> getUserById(@PathVariable ObjectId myId){
        Optional<User> user = userService.findById(myId);
        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<?> updateUser (@RequestBody User user){
        User userInDb = userService.findByUserName(user.getUserName());
        if(userInDb != null){
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteUserById(@PathVariable ObjectId myId){
        userService.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
