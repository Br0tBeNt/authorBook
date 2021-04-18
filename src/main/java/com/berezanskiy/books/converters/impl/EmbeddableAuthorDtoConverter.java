package com.berezanskiy.books.converters.impl;

import com.berezanskiy.books.converters.Converter;
import com.berezanskiy.books.dtos.EmbeddableAuthorDto;
import com.berezanskiy.books.entities.Author;
import org.springframework.stereotype.Component;

@Component("embeddableAuthorDtoConverter")
public class EmbeddableAuthorDtoConverter implements Converter<Author, EmbeddableAuthorDto> {

    @Override
    public EmbeddableAuthorDto convert(Author author) {
        return EmbeddableAuthorDto.builder()
                .id(author.getId())
                .penName(author.getPenName())
                .firstName(author.getFirstName())
                .surname(author.getSurname())
                .build();
    }
}
