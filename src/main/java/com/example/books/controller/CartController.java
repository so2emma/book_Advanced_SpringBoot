package com.example.books.controller;

import com.example.books.model.Book;
import com.example.books.model.Cart;
import com.example.books.service.impl.CartServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

    @Autowired
    public CartServiceImpl cartService;

    @PostMapping("/add/{cart}/book/{book}")
    public ResponseEntity<Cart> addBookToCart(@PathVariable Long cart, @PathVariable Long book){
        return cartService.addBookToCart(cart, book);
    }

    @PostMapping("/remove/{cart}/book/{book}")
    public ResponseEntity<Cart> removeBookFromCart(@PathVariable Long cart, @PathVariable Long book) {
        return cartService.removeBookFromCart(cart, book);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Cart>> getCart(@PathVariable Long id){
        return cartService.getCart(id);
    }

}
