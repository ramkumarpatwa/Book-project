package com.example.spring.mongodb.exceptions;

import com.example.spring.mongodb.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//centralized exception handler for handling excpetions of all controller in this project
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<CustomErrorResponse> bookNotFound(BookNotFoundException ex){
        CustomErrorResponse error = new CustomErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return new ResponseEntity<CustomErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(BookAlreadyPresentException.class)
    public ResponseEntity<CustomErrorResponse> bookAlreadyPresent(BookAlreadyPresentException ex){
        CustomErrorResponse error = new CustomErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        return new ResponseEntity<CustomErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
