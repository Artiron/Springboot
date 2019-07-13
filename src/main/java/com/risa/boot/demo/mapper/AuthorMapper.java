package com.risa.boot.demo.mapper;

import com.risa.boot.demo.entity.Author;
import com.risa.boot.demo.model.AuthorDto;
import org.mapstruct.Mapper;


import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDto toAuthorDTO(Author author);
    List<AuthorDto> toAuthorsDTO(List<Author> authors);
    Author toAuthor(AuthorDto authorDTO);
}



