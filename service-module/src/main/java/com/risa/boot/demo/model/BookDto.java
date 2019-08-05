package com.risa.boot.demo.model;

import java.util.Objects;

public class BookDto {
    private Long id;
    private String bookName;
    private Integer countPage;
    private Integer year;
    private AuthorDto author;

    public AuthorDto getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDto author) {
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Integer getCountPage() {
        return countPage;
    }

    public void setCountPage(Integer countPage) {
        this.countPage = countPage;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookDto bookDto = (BookDto) o;
        return Objects.equals(id, bookDto.id) &&
                Objects.equals(bookName, bookDto.bookName) &&
                Objects.equals(countPage, bookDto.countPage) &&
                Objects.equals(year, bookDto.year) &&
                Objects.equals(author, bookDto.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookName, countPage, year, author);
    }
}
