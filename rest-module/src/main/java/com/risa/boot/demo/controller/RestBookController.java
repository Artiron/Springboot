package com.risa.boot.demo.controller;

import com.risa.boot.demo.model.BookDto;
import com.risa.boot.demo.service.api.BookService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/books")
@Api(value = "Контроллер книг", tags = {"REST контроллер книг"})
public class RestBookController {

    private final BookService bookService;

    public RestBookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping(value = "/")
    @ApiOperation(value = "Вернет все книги", response = List.class)
    public List<BookDto> allBooks(){
        return bookService.allBooks();
    }

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Вернет книги по id", response = BookDto.class)
    public BookDto getBook(@PathVariable Long id){
        return bookService.getById(id);
    }

    @DeleteMapping(value = "delete/{id}")
    @ApiOperation(value = "Удалить книгу" )
    public void deleteBook(@PathVariable Long id) {
        bookService.deleteById(id);
    }

    @PostMapping(value = "save")
    @ApiOperation(value = "Сохранит книгу", response = BookDto.class)
    public BookDto bookSave(@ModelAttribute BookDto book){
       return bookService.save(book);
    }

    @GetMapping(value = "/getBooksByAuthorId/{id}")
    @ApiOperation(value = "Вернет все книги написанных автором", response = List.class)
    public List<BookDto> getBooksByAuthorId(@PathVariable Long id) {
        return bookService.getByAuthor(id);
    }
}
