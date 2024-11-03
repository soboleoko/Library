package com.example.Library.exception;

import org.springframework.http.HttpStatus;

public class BookNotFoundException extends RuntimeException {
    HttpStatus statusHTPP;

    public BookNotFoundException(String message, HttpStatus statusHTPP) {
        super(message);
        this.statusHTPP = statusHTPP;
    }
}
