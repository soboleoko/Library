package com.example.Library.service;

import com.example.Library.exception.BookBadRequestException;
import com.example.Library.exception.BookNotFoundException;
import com.example.Library.model.Book;
import com.example.Library.model.BookStats;
import com.example.Library.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.addBook(book);
    }

    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }

    public Book getBookByID(Integer bookID) {
        return bookRepository.getBookByID(bookID).orElseThrow(() ->
                new BookNotFoundException("Nie znaleziono książki o podanym ID", HttpStatus.NOT_FOUND));
    }

    public Book updateBook(Book newBookData, Integer bookID) {
        return bookRepository.updateBook(newBookData, bookID).orElseThrow(() ->
                new BookNotFoundException("Nie znaleziono książki o podanym ID", HttpStatus.NOT_FOUND));
    }

    public void deleteBook(Integer bookID) {
        bookRepository.deleteBook(bookID).orElseThrow(() ->
                new BookNotFoundException("Nie znaleziono książki o podanym ID", HttpStatus.NOT_FOUND));
    }

    public List<Book> findBookByTitle(String title) {
        return bookRepository.findBookByTitle(title);
    }

    public List<Book> getFilteredBooks(String author, Integer year) {
        return bookRepository.filterBooks(author, year);
    }

    public Book updateRating(Integer bookID, Double rating) {
        return bookRepository.updateRating(bookID, rating).orElseThrow(() ->
                new BookBadRequestException("Nie znaleziono książki o podanym ID lub zakres oceny " +
                        "jest spoza pomiędzy 1.0 i 5.0", HttpStatus.BAD_REQUEST));
    }

    public List<Book> getTopRating(Integer limit) {
        return bookRepository.getTopRating(limit);
    }

    public BookStats getBooksStats() {
        return bookRepository.getBooksStats();
    }
}
