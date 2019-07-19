package com.risa.boot.demo.service.api;



import com.risa.boot.demo.model.BookDto;

import java.util.List;

public interface BookService {
    List<BookDto> allBooks();

    BookDto save(BookDto book);

    List<BookDto> getByAuthor(Long id);

    void deleteById(Long id);

    void delete(BookDto book);

    BookDto getById(Long id);
}
