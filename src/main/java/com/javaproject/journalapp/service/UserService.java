package com.javaproject.journalapp.service;

import com.javaproject.journalapp.entity.User;
import com.javaproject.journalapp.repository.JournalEntryRepository;
import com.javaproject.journalapp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    private static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void saveNewUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Arrays.asList("USER"));
        userRepository.save(user);
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    // if there is no id present then the app might crash therefore we use optional here, it returns safe null values
    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }

//    code by edigest
//    public void deleteById(ObjectId id){
////        userRepository.deleteById(id); //by edigest
////        below given by AI
//        // 1. Fetch the user
//        User user = userRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
//        // 2. Delete all journal entries of this user
//        journalEntryRepository.deleteAllByUser(user);
//        // 3. Delete the user
//        userRepository.deleteById(id);
//    }


    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
}
