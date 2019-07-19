package com.risa.boot.demo.repository;

import com.risa.boot.demo.entity.Author;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
