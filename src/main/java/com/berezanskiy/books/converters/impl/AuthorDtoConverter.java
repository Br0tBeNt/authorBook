package com.berezanskiy.books.converters.impl;

import com.berezanskiy.books.converters.Converter;
import com.berezanskiy.books.dtos.AuthorDto;
import com.berezanskiy.books.dtos.EmbeddableBookDto;
import com.berezanskiy.books.entities.Author;
import com.berezanskiy.books.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("authorDtoConverter")
public class AuthorDtoConverter implements Converter<Author, AuthorDto> {

    @Autowired
    @Qualifier("embeddableBookDtoConverter")
    private Converter<Book, EmbeddableBookDto> converter;

    @Override
    public AuthorDto convert(Author author) {
        return AuthorDto.builder()
                .id(author.getId())
                .penName(author.getPenName())
                .firstName(author.getFirstName())
                .surname(author.getSurname())
                .books(converter.convertAll(author.getBooks()))
                .build();
    }
}
