package com.javaproject.journalapp.service;

import com.javaproject.journalapp.entity.JournalEntry;
import com.javaproject.journalapp.entity.User;
import com.javaproject.journalapp.repository.JournalEntryRepository;
import com.javaproject.journalapp.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void saveEntry(User user){
        userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    // if there is no id present then the app might crash therefore we use optional here, it returns safe null values
    public Optional<User> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public User findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
}
