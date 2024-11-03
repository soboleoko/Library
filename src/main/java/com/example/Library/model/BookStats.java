package com.example.Library.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class BookStats {
    private Double averageRating;
    private Integer booksAmount;
    private Long uniqueAuthorsAmount;
}
