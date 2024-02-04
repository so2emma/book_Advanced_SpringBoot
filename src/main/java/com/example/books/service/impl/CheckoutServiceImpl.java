package com.example.books.service.impl;

import com.example.books.model.Book;
import com.example.books.model.Cart;
import com.example.books.model.User;
import com.example.books.repositories.CartRepositories;
import com.example.books.response.CheckoutResponseHandler;
import com.example.books.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    @Autowired
    CartRepositories cartRepositories;

    @Override
    public Double calculatePrice(Cart cart) {
        double total = 0.00;
        List<Book> books = cart.getBooks();
        for(Book book: books) {
            Double cost = Double.valueOf(book.getCost());
            total += cost;
        }
        return total;
    }

    @Override
    public ResponseEntity<Object> getCheckoutDetails(Long id) {
        try{
            Optional<Cart> optionalCart = cartRepositories.findById(id);
            if (optionalCart.isPresent()){
                Cart cart = optionalCart.get();
                List<Book> books = cart.getBooks();
                User user = cart.getUser();
                Double total = cart.getTotal();

                return CheckoutResponseHandler.generateResponse("Checkout Details", HttpStatus.OK, user, books, total);
            }else {
                return CheckoutResponseHandler.generateErrorResponse("Incorrect Data", HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return CheckoutResponseHandler.generateErrorResponse(e.getMessage(), HttpStatus.MULTI_STATUS);
        }
    }
}
