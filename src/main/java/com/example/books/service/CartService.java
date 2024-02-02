package com.example.books.service;

import com.example.books.model.Book;
import com.example.books.model.Cart;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface CartService {

    ResponseEntity<Cart> addBookToCart (Long cartId, Long bookId);

    ResponseEntity<Cart> removeBookFromCart (Long cartId, Long bookId);

    ResponseEntity<Optional<Cart>> getCart (Long cartId);
}
