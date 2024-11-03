package com.example.Library.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class BookNotFoundExceptionHandler {
    @ExceptionHandler({BookNotFoundException.class})
    public ResponseEntity<Object> handleBookNotFound(Exception e, WebRequest request) {
        return new ResponseEntity<>(new ErrorMessage("Nie znaleziono podanej książki"), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> handleBookBadRequestException(Exception e, WebRequest request) {
        return new ResponseEntity<>(new ErrorMessage("Nie znaleziono książki o podanym ID lub zakres oceny jest" +
                " spoza pomiędzy 1.0 i 5.0"), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
