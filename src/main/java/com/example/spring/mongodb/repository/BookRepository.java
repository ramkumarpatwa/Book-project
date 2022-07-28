package com.example.spring.mongodb.repository;

import com.example.spring.mongodb.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookRepository extends MongoRepository<Book, Integer>{
    Book findByAuthorNameAndBookName(String authorName, String bookName);

    List<Book> findBookByAuthorName(String authorName);
}
