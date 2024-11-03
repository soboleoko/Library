package com.example.Library.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BookNotFoundException extends RuntimeException {

    public final HttpStatus httpStatus;

    public BookNotFoundException(String message, HttpStatus statusHTPP) {
        super(message);
        this.httpStatus = statusHTPP;
    }
}
