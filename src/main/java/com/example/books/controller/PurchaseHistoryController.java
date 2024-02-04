package com.example.books.controller;

import com.example.books.model.PurchaseHistory;
import com.example.books.service.impl.PurchaseHistoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/purchase")
public class PurchaseHistoryController {

    @Autowired
    PurchaseHistoryServiceImpl historyService;
    @PostMapping("/{id}")
    public ResponseEntity<PurchaseHistory> createPurchaseHistory(@PathVariable Long id) {
        return historyService.createPurchaseHistory(id);
    }

    @GetMapping("/user/history/{id}")
    public ResponseEntity<List<PurchaseHistory>> getPurchaseHistory(@PathVariable Long id) {
        return historyService.getPurchaseHistory(id);
    }
}
