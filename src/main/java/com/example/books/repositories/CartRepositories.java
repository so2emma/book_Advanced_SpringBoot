package com.example.books.repositories;

import com.example.books.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepositories extends JpaRepository<Cart, Long> {
}
