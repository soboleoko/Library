package com.example.Library.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BookBadRequestException extends RuntimeException {

    public final HttpStatus httpStatus;

    public BookBadRequestException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
