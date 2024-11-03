package com.example.Library.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExceptionHandler {
    @ExceptionHandler({BookNotFoundException.class})
    public ResponseEntity<ErrorMessage> handleBookNotFound(BookNotFoundException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(new ErrorMessage(e.getMessage()));
    }

    @ExceptionHandler({BookBadRequestException.class})
    public ResponseEntity<ErrorMessage> handleBookBadRequestException(BookBadRequestException e) {
        return ResponseEntity.status(e.getHttpStatus()).body(new ErrorMessage(e.getMessage()));
    }
}

