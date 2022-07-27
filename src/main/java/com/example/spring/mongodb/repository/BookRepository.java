package com.example.spring.mongodb.repository;

import com.example.spring.mongodb.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Integer>{
}
