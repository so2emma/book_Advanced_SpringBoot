package com.example.books.service.impl;

import com.example.books.model.Cart;
import com.example.books.model.PurchaseHistory;
import com.example.books.model.User;
import com.example.books.repositories.CartRepositories;
import com.example.books.repositories.PurchaseHistoryRepositories;
import com.example.books.repositories.UserRepositories;
import com.example.books.service.PurchaseHistoryService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PurchaseHistoryServiceImpl implements PurchaseHistoryService {

    @Autowired
    CartRepositories cartRepositories;

    @Autowired
    PurchaseHistoryRepositories historyRepositories;

    @Autowired
    UserRepositories userRepositories;

    @Override
    @Transactional
    public ResponseEntity<PurchaseHistory> createPurchaseHistory(Long id) {
        try{
            Optional<Cart> optionalCart  = cartRepositories.findById(id);
            if(optionalCart.isPresent()){
                Cart cart = optionalCart.get();

                PurchaseHistory history = new PurchaseHistory();
                history.setBooks(cart.getBooks());
                history.setTotal(cart.getTotal());

                historyRepositories.save(history);
                Optional<User> optionalUser = userRepositories.findById(id);

                if(optionalUser.isPresent()){
                    User user = optionalUser.get();
                    user.getPurchaseHistories().add(history);
                    userRepositories.save(user);
                }

                cart.setBooks(new ArrayList<>());
                cart.setTotal(0.00);

                cartRepositories.save(cart);

                return new ResponseEntity<>(history, HttpStatus.OK);

            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            e.printStackTrace(System.out);
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<List<PurchaseHistory>> getPurchaseHistory(Long id) {
        try{
            Optional<User> optionalUser = userRepositories.findById(id);
            if(optionalUser.isPresent()){
                User user = optionalUser.get();
                List<PurchaseHistory> histories = user.getPurchaseHistories();
                return new ResponseEntity<>(histories, HttpStatus.OK);
            }else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
