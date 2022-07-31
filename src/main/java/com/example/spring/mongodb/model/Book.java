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
    @Min(value = 1)
    @Max(value = 100)
    private int id;

    private String bookName;

    @Size(min=2, message="author name must be of atleast 2  characters")
    private String authorName;

    private LocalDateTime localDateTime;

    private int count;
}
