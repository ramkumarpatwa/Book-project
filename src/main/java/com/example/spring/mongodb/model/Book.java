package com.example.spring.mongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@Document(collection = "Book")
public class Book {

    @Id
    private int id;

    private String bookName;

    private String authorName;

    private LocalDateTime localDateTime;
}
