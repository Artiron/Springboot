package com.risa.boot.demo.controller;

import com.risa.boot.demo.model.BookDto;
import com.risa.boot.demo.service.api.BookService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/books")
public class RestBookController {

    private final BookService bookService;

    public RestBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/")
    public List<BookDto> allBooks(){
        return bookService.allBooks();
    }

    @GetMapping(value = "/{id}")
    public BookDto getBook(@PathVariable Long id){
        return bookService.getById(id);
    }

    @DeleteMapping(value = "delete/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @PostMapping(value = "save")
    public BookDto bookSave(@ModelAttribute BookDto book){
       return bookService.save(book);
    }

    @GetMapping(value = "/getBooksByAuthorId/{id}")
    public List<BookDto> getBooksByAuthorId(@PathVariable Long id) {
        return bookService.getByAuthor(id);
    }
}
