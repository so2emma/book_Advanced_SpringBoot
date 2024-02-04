package com.example.books.service;

import com.example.books.model.Cart;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CheckoutService {

    Double calculatePrice(Cart cart);

    ResponseEntity<Object> getCheckoutDetails(Long id);

}
