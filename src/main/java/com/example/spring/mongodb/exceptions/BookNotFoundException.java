package com.example.spring.mongodb.exceptions;

public class BookNotFoundException extends  RuntimeException{

    public BookNotFoundException(String msg){
        super(msg);
    }

}
