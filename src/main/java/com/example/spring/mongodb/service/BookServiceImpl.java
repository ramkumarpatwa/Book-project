package com.example.spring.mongodb.service;

import com.example.spring.mongodb.exceptions.BookNotFoundException;
import com.example.spring.mongodb.model.Book;
import com.example.spring.mongodb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    //when id > 50 authorname = Sushma
    // set current time + 1
    @Override
    public Book saveBookMethod(Book book) {
        book.setLocalDateTime(LocalDateTime.now().plusHours(1));
        if(book.getId()>50)
                book.setAuthorName("Sushma");
        //
         return bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBookById(int id) {
        Optional<Book> book = bookRepository.findById(id);
        if(book.isPresent())
            return book;
        else throw new BookNotFoundException("Book with given id doesn't exist");
    }

    @Override
    public List<String> getAllBookName(){
        List<String> bookNameList = new ArrayList<>();
        List<Book> allBooks = bookRepository.findAll();
        for(Book book: allBooks){
            bookNameList.add(book.getBookName());
        }
        return bookNameList;
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Book updateBookById(Book book, int id) {
        //check if book is present with the id
        Optional<Book> existingBookPresentInDbInOptionalFormat = bookRepository.findById(id);
        Book existingBookPresentInDbInObjectFormat =  null;
        if(existingBookPresentInDbInOptionalFormat.isPresent()){
            existingBookPresentInDbInObjectFormat = existingBookPresentInDbInOptionalFormat.get();
            existingBookPresentInDbInObjectFormat.setBookName(book.getBookName());
            existingBookPresentInDbInObjectFormat.setAuthorName(book.getAuthorName());
        }
        bookRepository.save(existingBookPresentInDbInObjectFormat);
        return existingBookPresentInDbInObjectFormat;
    }

    @Override
    public List<String> getAllAuthorName() {
        List<String> authorNameList = new ArrayList<>();
        List<Book> books = bookRepository.findAll();
        for(Book authorName : books){
            authorNameList.add(authorName.getAuthorName());
        }

        return authorNameList;
    }
}
