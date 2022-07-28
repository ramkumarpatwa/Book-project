package com.example.spring.mongodb.controller;

import com.example.spring.mongodb.model.Book;
import com.example.spring.mongodb.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    /**
     * Api to save book
     * @param book passing book as requestbody
     * @return Book which will be saved as responseBody
     */
    @PostMapping("/saveBook")
    public Book saveBook(@Valid @RequestBody Book book){
        return bookService.saveBookMethod(book);
    }


    //To get a book by id
    @GetMapping("/getBook/{id}")
    public Optional<Book> getBookById(@PathVariable int id){
            Optional<Book> book = bookService.getBookById(id);
//        if(book.isPresent())
//            return book;
//        else return bookService.getBookByIdMet(13);
        return book;
    }

    // return list of all book name
    @GetMapping("/getAllBookName")
    public List<String> getAllBookName(){
        return bookService.getAllBookName();
    }

    // return book details by passing author name and book name as RequestParam
    @GetMapping("/getBook")
    public Book getBookByRequestParam(@RequestParam  String authorName, @RequestParam String bookName){
        return bookService.getBookByAuthorNameAndBookNameWithRequestParam(authorName, bookName);
    }

    /**
     * Api to get book by authorName and bookName
     * @param authorName authorName
     * @param bookName bookName
     * @return book with given authorName and bookName
     */
    @GetMapping("/getBook/{authorName}/{bookName}")
    public Book getBook(@PathVariable  String authorName, @PathVariable String bookName){
        return bookService.getBookByAuthorNameAndBookName(authorName, bookName);
    }

    // To get list of all books
    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    //To Delete a book
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable int id){
        bookService.deleteById(id);
    }

    // To update a book
    @PutMapping("/update/{id}")
    public Book updateBook(@RequestBody Book book, @PathVariable int id){
       return bookService.updateBookById(book, id);
    }

    /**
     * Api to get List of authorName from book details
     * @return  list of authorName
     */
    @GetMapping("/getAllAuthorName")
    public List<String> authorName(){
        return bookService.getAllAuthorName();

    }




}
