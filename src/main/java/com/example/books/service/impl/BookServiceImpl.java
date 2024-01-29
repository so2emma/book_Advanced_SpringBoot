package com.example.books.service.impl;

import com.example.books.repositories.BookRepositories;
import com.example.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepositories bookRepositories;
}
