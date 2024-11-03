package com.example.Library.controller;

import com.example.Library.mapper.BookMapper;
import com.example.Library.mapper.BookStatsMapper;
import com.example.Library.model.*;
import com.example.Library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;
    private final BookMapper bookMapper;
    private final BookStatsMapper bookStatsMapper;

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO addBook(@RequestBody Book book) {
        return bookMapper.mapToBookDTO(bookService.addBook(book));
    }

    @GetMapping("/books")
    public List<BookDTO> getBooks() {
        return bookMapper.mapToBookDTOList(bookService.getBooks());
    }

    @GetMapping("/books/{bookID}")
    public BookDTO getBooksByID(@PathVariable Integer bookID) {
        return bookMapper.mapToBookDTO(bookService.getBookByID(bookID));
    }

    @PutMapping("/books/{bookID}")
    public BookDTO updateBook(@PathVariable Integer bookID, @RequestBody Book newBookData) {
        return bookMapper.mapToBookDTO(bookService.updateBook(newBookData, bookID));
    }

    @DeleteMapping("/books/{bookID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Integer bookID) {
        bookService.deleteBook(bookID);
    }

    @GetMapping("/books/search")
    public List<BookDTO> findBookByTitle(@RequestParam String title) {
        return bookMapper.mapToBookDTOList(bookService.findBookByTitle(title));
    }

    @GetMapping("/books/filter")
    public List<BookDTO> filterBooksByAuthorOrYear(@RequestParam(required = false) String author,
                                                @RequestParam(required = false) Integer year) {
        return bookMapper.mapToBookDTOList(bookService.getFilteredBooks(author, year));
    }

    @PatchMapping("/books/{bookID}/update-rating")
    public BookDTO updateBookRating(@PathVariable Integer bookID, @RequestBody BookRating rating) {
        return bookMapper.mapToBookDTO(bookService.updateRating(bookID, rating));
    }

    @GetMapping("/books/top-rated")
    public List<BookDTO> getTopRating(@RequestParam Integer limit) {
        return bookMapper.mapToBookDTOList(bookService.getTopRating(limit));
    }

    @GetMapping("/books/stats")
    public BookStatsDTO getBooksStats() {
        return bookStatsMapper.mapToBookStatsDTO(bookService.getBooksStats());
    }
}
