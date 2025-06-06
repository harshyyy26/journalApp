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

    //working it is
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAll();
    }

    //working it is
    @PostMapping
    public void createUser(@RequestBody User user){
        userService.saveEntry(user);
    }

    //working
    @GetMapping("id/{myId}")
    public ResponseEntity<?> getUserById(@PathVariable ObjectId myId){
        Optional<User> user = userService.findById(myId);
        if(user.isPresent()){
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }

//    working but u have to changes both username and pass
    @PutMapping("/{userName}") //we find by username and then update the users password
    public ResponseEntity<?> updateUser (@RequestBody User user, @PathVariable String userName){
        User userInDb = userService.findByUserName(userName);
        if(userInDb != null){
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    //working
    @DeleteMapping("/id/{myId}")
    public ResponseEntity<?> deleteUserById(@PathVariable ObjectId myId){
        userService.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
