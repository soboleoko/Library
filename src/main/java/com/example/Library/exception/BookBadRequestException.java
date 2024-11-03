package com.example.Library.exception;

import org.springframework.http.HttpStatus;

public class BookBadRequestException extends RuntimeException {

    public final HttpStatus httpStatus;

    public BookBadRequestException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
