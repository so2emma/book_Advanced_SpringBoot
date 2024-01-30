package com.example.books.service.impl;

import com.example.books.model.Book;
import com.example.books.repositories.BookRepositories;
import com.example.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    public BookRepositories bookRepositories;

    @Override
    public ResponseEntity<List<Book>> getAllBooks() {
        try{
            return new ResponseEntity<>(bookRepositories.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    // @Override
    // public ResponseEntity<List<Book>> searchBooks(String query) {
    //     try{
    //         return new ResponseEntity<>(bookRepositories.searchByProperty(query), HttpStatus.OK);
    //     }catch (Exception e) {
    //         e.printStackTrace();
    //     }
    //     return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    // }

    @Override
    public ResponseEntity<Optional<Book>> getBookById(Long id) {
        try{
            return new ResponseEntity<>(bookRepositories.findById(id), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @Override
    public ResponseEntity<Book> addBook(Book book) {
        try{
            return new ResponseEntity<>(bookRepositories.save(book), HttpStatus.CREATED);
        }catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Book> updateBook(Long id, Book updatedBook) {
        Optional<Book> optionalBook = bookRepositories.findById(id);
        if (optionalBook.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Book book = optionalBook.get();
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setGenre(updatedBook.getGenre());
        book.setIsbn(updatedBook.getIsbn());
        book.setPublicationYear(updatedBook.getPublicationYear());

        return new ResponseEntity<>(bookRepositories.save(book), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Void> deleteBook(Long id) {
        Optional<Book> optionalBook = bookRepositories.findById(id);
        if (optionalBook.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bookRepositories.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
