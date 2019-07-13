package com.risa.boot.demo.service.api;

import com.risa.boot.demo.model.AuthorDto;


import java.util.List;

public interface AuthorService {
    List<AuthorDto> allAuthors();

    void delete(AuthorDto author);

    void deleteById(Long id);

    AuthorDto save(AuthorDto author);

    AuthorDto getById(Long id);
}
