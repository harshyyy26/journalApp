package com.javaproject.journalapp.entity;

import com.javaproject.journalapp.service.JournalEntryService;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Date;

//pojo-plain old java object
@Document("journal_entries") // every object will be equal to a row in the db
@Data //generates getters setters s=during complie time
public class JournalEntry {

    @Id
    private ObjectId id;
    @NonNull
    private String title;
    private String content;
    private LocalDateTime date;

}
