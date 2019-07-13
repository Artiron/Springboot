package com.risa.boot.demo.controller;

import com.risa.boot.demo.model.AuthorDto;
import com.risa.boot.demo.service.api.AuthorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allAuthors() {
        List<AuthorDto> authors = authorService.allAuthors();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("authors");
        modelAndView.addObject("authorsList", authors);
        return modelAndView;
    }

    @RequestMapping(value = "edit/{id}", method = RequestMethod.GET)
    public ModelAndView getEditPage(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editAuthorPage");
        AuthorDto authorDto = authorService.getById(id);
        modelAndView.addObject("author", authorDto);

        return modelAndView;
    }

    @RequestMapping(value = "edit", method = RequestMethod.POST)
    public ModelAndView saveAuthor(@ModelAttribute AuthorDto author) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/authors/");
        authorService.save(author);

        return modelAndView;
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public ModelAndView addAuthor(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editAuthorPage");
        modelAndView.addObject("author", new AuthorDto());

        return modelAndView;
    }




}
