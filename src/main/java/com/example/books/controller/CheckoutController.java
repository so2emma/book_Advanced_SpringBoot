package com.example.books.controller;

import com.example.books.service.impl.CheckoutServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/checkout")
public class CheckoutController {

    @Autowired
    CheckoutServiceImpl checkoutService;


    @GetMapping("/details/{id}")
    public ResponseEntity<Object> getCheckoutDetails(@PathVariable Long id){
        return checkoutService.getCheckoutDetails(id);
    };
}
