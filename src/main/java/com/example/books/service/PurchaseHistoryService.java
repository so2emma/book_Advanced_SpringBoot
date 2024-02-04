package com.example.books.service;

import com.example.books.model.PurchaseHistory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PurchaseHistoryService {
    ResponseEntity<PurchaseHistory> createPurchaseHistory(Long id);

    ResponseEntity<List<PurchaseHistory>> getPurchaseHistory(Long id);
}
