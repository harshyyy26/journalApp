package com.javaproject.journalapp.entity;

import lombok.Data;
import lombok.NonNull;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexOptions;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//pojo-plain old java object
@Document("users") // every object will be equal to a row in the db
@Data //generates getters setters s=during complie time 
public class User {

    @Id
    private ObjectId id;
    @Indexed(unique = true) //index automatic create no hoga so to create set application properties (no. 4)
    @NonNull
    private String userName;
    @NonNull
    private String password;

    @DBRef //creating reference of JournalEntry  under users collection
    private List<JournalEntry> journalEntries = new ArrayList<>();
}
