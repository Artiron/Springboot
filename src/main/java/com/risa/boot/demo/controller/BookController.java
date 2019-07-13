package com.risa.boot.demo.controller;

import com.risa.boot.demo.model.BookDto;
import com.risa.boot.demo.service.api.AuthorService;
import com.risa.boot.demo.service.api.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allBooks() {
        List<BookDto> books = bookService.allBooks();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("books");
        modelAndView.addObject("booksList", books);
        return modelAndView;
    }

    @RequestMapping(value = "getByAuthor/{id}", method = RequestMethod.GET)
    public ModelAndView getByAuthor(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("books");
        List<BookDto> booksList = bookService.getByAuthor(id);
        modelAndView.addObject("booksList", booksList);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") Long id) {
        BookDto book = bookService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bookEditPage");
        modelAndView.addObject("book", book);
        modelAndView.addObject("authors", authorService.allAuthors());
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editBook(@ModelAttribute("book") BookDto book) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/books/");
        bookService.save(book);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("bookEditPage");
        BookDto book = new BookDto();
        modelAndView.addObject("book", book);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addBook(@ModelAttribute("book") BookDto book) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/books/");
        bookService.save(book);
        return modelAndView;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteBook(@PathVariable("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/books/");
        BookDto book = bookService.getById(id);
        bookService.delete(book);
        return modelAndView;
    }


}

