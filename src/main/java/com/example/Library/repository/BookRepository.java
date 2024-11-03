package com.example.Library.repository;

import com.example.Library.model.Book;
import com.example.Library.model.BookStats;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@Repository
@RequiredArgsConstructor
public class BookRepository {
    private final List<Book> books = new ArrayList<>();

    public Book addBook(Book book) {

        Integer maxID = books.stream()
                .map(Book::getBookID)
                .max(Integer::compare)
                .orElse(0);

        book.setBookID(maxID + 1);

        books.add(book);
        return book;
    }

    public Optional<Book> getBookByID(Integer bookID) {
        return books.stream()
                .filter(bookByID -> bookByID.getBookID().equals(bookID))
                .findFirst();
    }

    public Optional<Book> updateBook(Book newBookData, Integer bookID) {
        Optional<Book> bookByID = getBookByID(bookID);
        if (bookByID.isPresent()) {
            Book foundBook = bookByID.get();
            foundBook.setAuthor(newBookData.getAuthor());
            foundBook.setTitle(newBookData.getTitle());
            foundBook.setYear(newBookData.getYear());
            foundBook.setRating(newBookData.getRating());
        }
        return bookByID;
    }

    public Optional<Book> deleteBook(Integer bookID) {
        Optional<Book> bookByID = getBookByID(bookID);
        if (bookByID.isPresent()) {
            Book foundBook = bookByID.get();
            books.remove(foundBook);
        }
        return bookByID;
    }

    public List<Book> findBookByTitle(String title) {
        List<Book> foundBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase().trim())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

    public List<Book> filterBooks(String author, Integer year) {
        return books.stream()
                .filter(book -> author == null || book.getAuthor().equalsIgnoreCase(author))
                .filter(book -> year == null || book.getYear().equals(year))
                .collect(Collectors.toList());
    }

    public Optional<Book> updateRating(Integer bookID, Double rating) {
        Optional<Book> bookByID = getBookByID(bookID);
        if (bookByID.isPresent() && rating >= 1.0 && rating <= 5.0) {
            Book foundBook = bookByID.get();
            foundBook.setRating(rating);
        }
        return bookByID;
    }

    public List<Book> getTopRating(Integer limit) {
        return books.stream()
                .sorted(Comparator.comparingDouble(Book::getRating))
                .limit(limit)
                .toList();
    }

    public BookStats getBooksStats() {
        DoubleSummaryStatistics ratingStats = books.stream()
                .mapToDouble(Book::getRating)
                .summaryStatistics();

        int totalBooks = books.size();

        long uniqueAuthors = books.stream()
                .map(Book::getAuthor)
                .distinct()
                .count();

        return new BookStats(ratingStats.getAverage(), totalBooks, uniqueAuthors);
    }
}
