package com.example.Library.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class Book {
    private Integer bookID;
    private String title;
    private String author;
    private Integer year;
    private Double rating;
}
