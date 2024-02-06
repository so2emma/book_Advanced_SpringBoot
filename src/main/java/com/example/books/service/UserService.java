package com.example.books.service;


import com.example.books.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    ResponseEntity<List<User>> getAllUsers();
    ResponseEntity<Optional<User>> getUserById(Long id);
    ResponseEntity<Optional<User>> getUserByName(String name);
    ResponseEntity<User> addUser(User user);
    ResponseEntity<User> updateUser(Long id, User user);

}
