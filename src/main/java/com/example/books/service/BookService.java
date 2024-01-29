package com.example.books.service;

import com.example.books.model.Book;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface BookService {

    ResponseEntity<List<Book>> getAllBooks();
    ResponseEntity<List<Book>> searchBooks(String query);
    ResponseEntity<Optional<Book>> getBookById(Long id);
    ResponseEntity<Book> addBook(Book book);
    ResponseEntity<Book> updateBook(Long id, Book book);
    ResponseEntity<String> deleteBook(Long id);


}
