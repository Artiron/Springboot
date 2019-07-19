package com.risa.boot.demo.repository;


import com.risa.boot.demo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooksRepository  extends JpaRepository<Book, Long> {
    List<Book> getBooksByAuthorId(Long id);
}
