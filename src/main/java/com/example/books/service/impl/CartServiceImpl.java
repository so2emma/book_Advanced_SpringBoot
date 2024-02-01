package com.example.books.service.impl;

import com.example.books.model.Book;
import com.example.books.model.Cart;
import com.example.books.repositories.BookRepositories;
import com.example.books.repositories.CartRepositories;
import com.example.books.service.CartService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    public CartRepositories cartRepositories;

    @Autowired
    public BookRepositories bookRepositories;

    @Override
//    @Transactional
    public ResponseEntity<Cart> addBookToCart(Long cartId, Book book) {
        try{
            Optional<Cart> optionalCart  =  cartRepositories.findById(cartId);
            if(optionalCart.isPresent()){
                Cart cart = optionalCart.get();
                cart.getBooks().add(book);
                return new ResponseEntity<>(cart, HttpStatus.CREATED);
            }
        } catch(Exception e) {
            e.printStackTrace(System.out);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    @Transactional
    public ResponseEntity<Cart> removeBookFromCart(Long cartId, Book book) {
        try{
            Optional<Cart> optionalCart  =  cartRepositories.findById(cartId);
            if(optionalCart.isPresent()){
                Cart cart = optionalCart.get();
                Set<Book> books  = cart.getBooks();

                if(books.contains(book))
                {
                    cart.getBooks().remove(book);
                    return new ResponseEntity<>(cart, HttpStatus.OK);
                }
                else {
                    return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
                }
            }
        } catch(Exception e) {
            e.printStackTrace(System.out);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Optional<Cart>> getCart(Long cartId) {
        try {
            return new ResponseEntity<>(cartRepositories.findById(cartId), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
