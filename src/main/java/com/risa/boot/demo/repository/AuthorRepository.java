package com.risa.boot.demo.repository;

import com.risa.boot.demo.entity.Author;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
//    List allAuthors();
//
//    void add(Author author);
//
//    void delete(Author author);
//
//    void edit(Author author);
//
//    Author getById(Long id);
}
