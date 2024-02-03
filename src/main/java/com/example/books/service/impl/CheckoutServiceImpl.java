package com.example.books.service.impl;

import com.example.books.model.Book;
import com.example.books.model.Cart;
import com.example.books.service.CheckoutService;

import java.util.List;

public class CheckoutServiceImpl implements CheckoutService {
    @Override
    public Double calculatePrice(Cart cart) {
        Double total = null;
        List<Book> books = cart.getBooks();
        for(Book book: books) {
            Double cost = Double.valueOf(book.getCost());
            total += cost;
        }
        return total;
    }
}
