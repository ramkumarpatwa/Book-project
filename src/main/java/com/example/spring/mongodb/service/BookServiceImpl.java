package com.example.spring.mongodb.service;

import com.example.spring.mongodb.model.Book;
import com.example.spring.mongodb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepository bookRepository;

    //when id > 50 authorname = Sushma
    // set current time + 1
    @Override
    public void saveBookMethod(Book book) {
        book.setLocalDateTime(LocalDateTime.now().plusHours(1));
        if(book.getId()>50)
                book.setAuthorName("Sushma");
        //
         bookRepository.save(book);
    }

    @Override
    public Optional<Book> getBookById(int id) {
        return bookRepository.findById(id);
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
}
