package com.example.books.service;

import com.example.books.model.Book;
import com.example.books.model.Cart;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface CartService {

    ResponseEntity<Cart> addBookToCart (Long cartId, Book book);

    ResponseEntity<Cart> removeBookFromCart (Long cartId, Book book);

    ResponseEntity<Optional<Cart>> getCart (Long cartId);
}
