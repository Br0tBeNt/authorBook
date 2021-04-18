package com.berezanskiy.books.converters.impl;

import com.berezanskiy.books.converters.Converter;
import com.berezanskiy.books.dtos.EmbeddableBookDto;
import com.berezanskiy.books.entities.Book;
import org.springframework.stereotype.Component;

@Component("embeddableBookDtoConverter")
public class EmbeddableBookDtoConverter implements Converter<Book, EmbeddableBookDto> {

    @Override
    public EmbeddableBookDto convert(Book book) {
        return EmbeddableBookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .build();
    }
}
