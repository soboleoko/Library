package com.example.Library.controller;

import com.example.Library.model.Book;
import com.example.Library.model.BookStats;
import com.example.Library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor

public class BookController {
    private final BookService bookService;

    @PostMapping("/books")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/books/{bookID}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Book getBooksByID(@PathVariable Integer bookID) {
        return bookService.getBookByID(bookID);
    }

    @PutMapping("/books/{bookID}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Book updateBook(@RequestBody Book newBookData, @PathVariable Integer bookID) {
        return bookService.updateBook(newBookData, bookID);
    }

    @DeleteMapping("/books/{bookID}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public void deleteBook(@PathVariable Integer bookID) {
        bookService.deleteBook(bookID);
    }

    @GetMapping("/books/search?title={title}")
    public List<Book> findBookByTitle(@RequestParam String title) {
        return bookService.findBookByTitle(title);
    }

    @GetMapping("/books/search?author={author}&year={year}")
    public List<Book> filterBooksByAuthorOrYear(@RequestParam(required = false) String author
            , @RequestParam(required = false) Integer year) {
        return bookService.getFilteredBooks(author, year);
    }

    @PatchMapping("/books/{bookID}/rating")
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Book updateBookRating(@PathVariable Integer bookID, @RequestBody double rating) {
        return bookService.updateRating(bookID, rating);
    }

    @GetMapping("/books/top-rated?limit={limit}")
    public List<Book> getTopRating(@RequestParam Integer limit) {
        return bookService.getTopRating(limit);
    }

    @GetMapping("/books/stats")
    public BookStats getBooksStats() {
        return bookService.getBooksStats();
    }
}
