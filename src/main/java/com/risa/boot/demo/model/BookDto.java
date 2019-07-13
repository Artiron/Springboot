package com.risa.boot.demo.model;

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
}
