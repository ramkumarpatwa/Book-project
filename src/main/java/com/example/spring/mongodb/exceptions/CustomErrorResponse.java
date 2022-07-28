package com.example.spring.mongodb.exceptions;


import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomErrorResponse {
    private int errorCode;
    private String errorMessage;
}