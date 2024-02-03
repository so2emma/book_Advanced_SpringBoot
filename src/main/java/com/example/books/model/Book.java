package com.example.books.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.Year;
import java.util.Set;


@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
@Entity
@Table(name = "books")
public class Book {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private String genre;
    private String isbn;
    private Year publicationYear;
    private Long cost;

}
