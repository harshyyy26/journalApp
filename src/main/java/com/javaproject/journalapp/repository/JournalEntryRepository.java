package com.javaproject.journalapp.repository;

import com.javaproject.journalapp.entity.JournalEntry;
import com.javaproject.journalapp.entity.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface JournalEntryRepository extends MongoRepository<JournalEntry, ObjectId> {
    void deleteAllByUser(User user);//given by ai
}
