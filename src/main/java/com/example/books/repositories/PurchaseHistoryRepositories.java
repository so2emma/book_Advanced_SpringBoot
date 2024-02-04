package com.example.books.repositories;

import com.example.books.model.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseHistoryRepositories extends JpaRepository<PurchaseHistory, Long> {
}
