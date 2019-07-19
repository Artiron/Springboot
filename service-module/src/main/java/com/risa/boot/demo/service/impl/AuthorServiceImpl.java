package com.risa.boot.demo.service.impl;

import com.risa.boot.demo.mapper.AuthorMapper;
import com.risa.boot.demo.entity.Author;
import com.risa.boot.demo.model.AuthorDto;
import com.risa.boot.demo.repository.AuthorRepository;
import com.risa.boot.demo.service.api.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    private AuthorMapper authorMapper;
    private AuthorRepository authorRepository;


    public AuthorServiceImpl(AuthorMapper authorMapper, AuthorRepository authorRepository) {
        this.authorMapper = authorMapper;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<AuthorDto> allAuthors() {
        List<Author> authors = authorRepository.findAll();
        List<AuthorDto> authorDtos = authorMapper.toAuthorsDTO(authors);
        return authorDtos;
    }

    @Override
    public void delete(AuthorDto authorDto) {
        Author author  = authorMapper.toAuthor(authorDto);
        authorRepository.delete(author);
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
    }

    @Override
    public AuthorDto save(AuthorDto authorDto) {
        Author author = authorMapper.toAuthor(authorDto);
        return  authorMapper.toAuthorDTO(authorRepository.save(author));
    }

    @Override
    public AuthorDto getById(Long id) {
        return  authorMapper.toAuthorDTO(authorRepository.getOne(id));

    }
}
