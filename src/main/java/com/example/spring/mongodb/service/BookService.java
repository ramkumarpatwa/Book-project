package com.example.spring.mongodb.service;

import com.example.spring.mongodb.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    public Book saveBookMethod(Book book);

    public List<Book> getAllBooks();

    public void deleteById(int id);


    Book updateBookById(Book book, int id);

    Optional<Book> getBookById(int id);

    List<String> getAllBookName();

    List<String> getAllAuthorName();

    Book getBookByAuthorNameAndBookName(String authorName, String bookName);

    Book getBookByAuthorNameAndBookNameWithRequestParam(String authorName, String bookName);

    List<Book> getBookByAuthorName(String authorName);
}
