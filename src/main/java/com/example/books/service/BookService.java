package com.example.books.service;

import com.example.books.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface BookService {

    ResponseEntity<List<Book>> getAllBooks();
    ResponseEntity<Optional<Book>> getBookById(Long id);
    ResponseEntity<Book> addBook(Book book);
    ResponseEntity<Book> updateBook(Long id, Book book);
    ResponseEntity<Void> deleteBook(Long id);


}
