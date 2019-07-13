package com.risa.boot.demo.mapper;


import com.risa.boot.demo.entity.Book;
import com.risa.boot.demo.model.BookDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = AuthorMapper.class)
public interface BookMapper {
    @Mapping(source = "name", target = "bookName")
    BookDto toBookDto(Book book);

    List<BookDto> toBookDtoList(List<Book> books);

    @InheritInverseConfiguration
    Book toBook(BookDto bookDto);

    List<Book> toBookList(List<BookDto> bookDtos);
}
