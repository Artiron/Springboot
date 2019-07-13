package com.risa.boot.demo.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @OneToMany(mappedBy = "author")
    private Set<Book> books;

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return Objects.equals(id, author.id) &&
                Objects.equals(fullName, author.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName);
    }
}
