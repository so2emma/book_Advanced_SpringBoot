package com.example.books.service.impl;

import com.example.books.model.Book;
import com.example.books.repositories.BookRepositories;
import com.example.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepositories bookRepositories;

    @Override
    public ResponseEntity<List<Book>> getAllBooks() {
        return null;
    }

    @Override
    public ResponseEntity<List<Book>> searchBooks(String query) {
        return null;
    }

    @Override
    public ResponseEntity<Book> getBookById(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Book> addBook(Book book) {
        return null;
    }

    @Override
    public ResponseEntity<Book> updateBook(Long id, Book book) {
        return null;
    }

    @Override
    public ResponseEntity<String> deleteBook(Long id) {
        return null;
    }
}
