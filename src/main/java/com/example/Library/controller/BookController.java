package com.example.Library.controller;

import com.example.Library.model.Book;
import com.example.Library.model.BookRating;
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
    public Book getBooksByID(@PathVariable Integer bookID) {
        return bookService.getBookByID(bookID);
    }

    @PutMapping("/books/{bookID}")
    public Book updateBook(@PathVariable Integer bookID, @RequestBody Book newBookData) {
        return bookService.updateBook(newBookData, bookID);
    }

    @DeleteMapping("/books/{bookID}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Integer bookID) {
        bookService.deleteBook(bookID);
    }

    @GetMapping("/books/search")
    public List<Book> findBookByTitle(@RequestParam String title) {
        return bookService.findBookByTitle(title);
    }

    @GetMapping("/books/filter")
    public List<Book> filterBooksByAuthorOrYear(@RequestParam(required = false) String author
            , @RequestParam(required = false) Integer year) {
        return bookService.getFilteredBooks(author, year);
    }

    @PatchMapping("/books/{bookID}/update-rating")
    public Book updateBookRating(@PathVariable Integer bookID, @RequestBody BookRating rating) {
        return bookService.updateRating(bookID, rating);
    }

    @GetMapping("/books/top-rated")
    public List<Book> getTopRating(@RequestParam Integer limit) {
        return bookService.getTopRating(limit);
    }

    @GetMapping("/books/stats")
    public BookStats getBooksStats() {
        return bookService.getBooksStats();
    }
}
