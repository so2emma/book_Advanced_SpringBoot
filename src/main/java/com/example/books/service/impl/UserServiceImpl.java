package com.example.books.service.impl;

import com.example.books.model.Cart;
import com.example.books.model.User;
import com.example.books.repositories.CartRepositories;
import com.example.books.repositories.UserRepositories;
import com.example.books.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserRepositories userRepositories;

    @Autowired
    public CartRepositories cartRepositories;

    @Override
    public ResponseEntity<List<User>> getAllUsers() {
        try{
            return new ResponseEntity<>(userRepositories.findAll(), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Optional<User>> getUserById(Long id) {
        try{
            return new ResponseEntity<>(userRepositories.findById(id), HttpStatus.OK);
        }catch(Exception e) {
            e.printStackTrace(System.out);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Optional<User>> getUserByName(String name) {
        try{
            return new ResponseEntity<>(userRepositories.findByName(name), HttpStatus.OK);
        }catch(Exception e) {
            e.printStackTrace(System.out);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    @Transactional
    public ResponseEntity<User> addUser(User user) {
        try{
            Cart cart = new Cart();
            user.setCart(cart);
            cart.setUser(user);
            return new ResponseEntity<>(userRepositories.save(user), HttpStatus.CREATED);
        }catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<User> updateUser(Long id, User updatedUser) {
        Optional<User> optionalUser = userRepositories.findById(id);
        if(optionalUser.isEmpty())
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        User user = optionalUser.get();
        user.setName(updatedUser.getName());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());

        return new ResponseEntity<>(userRepositories.save(user), HttpStatus.OK);
    }
}
