package com.example.books.repositories;

import com.example.books.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepositories extends JpaRepository<Book, Long> {
@Query("SELECT b FROM Book b WHERE b.title LIKE %?1% OR b.author LIKE %?1% OR b.genre LIKE %?1% OR b.publicationYear LIKE %?1%")
    List<Book> findBookByProperty(String query);
}
