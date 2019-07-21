package com.risa.boot.demo.controller;

import com.risa.boot.demo.model.AuthorDto;
import com.risa.boot.demo.service.api.AuthorService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/authors")
@Api(value = "Контроллер авторов", tags = {"REST контроллер авторов"})
public class RestAuthorController {

    private final AuthorService authorService;

    public RestAuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping(value = "/")
    @ApiOperation(value = "Вернет всех авторов", response = List.class)
    public List<AuthorDto> allAuthors() {
        return authorService.allAuthors();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Вернет конкретного автора", response = AuthorDto.class)
    public AuthorDto getAuthor(@PathVariable Long id) {
        return authorService.getById(id);
    }

    @PostMapping(value = "save")
    @ApiOperation(value = "Сохранит автора", response = AuthorDto.class)
    public AuthorDto saveAuthor(@ModelAttribute AuthorDto author) {
        return authorService.save(author);
    }

    @DeleteMapping(value = "delete/{id}")
    @ApiOperation(value = "Удалит автора")
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteById(id);
    }
}
