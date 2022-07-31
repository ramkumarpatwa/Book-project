package com.example.spring.mongodb.exceptions;

public class BookAlreadyPresentException extends  RuntimeException{

    public BookAlreadyPresentException(String msg){
        super(msg);
    }
}
