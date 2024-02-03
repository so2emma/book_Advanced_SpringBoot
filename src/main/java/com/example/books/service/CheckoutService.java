package com.example.books.service;

import com.example.books.model.Cart;

public interface CheckoutService {

    Double calculatePrice(Cart cart);
}
