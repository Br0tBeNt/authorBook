package com.berezanskiy.books.converters.impl;

import com.berezanskiy.books.converters.Converter;
import com.berezanskiy.books.dtos.BookDto;
import com.berezanskiy.books.dtos.EmbeddableAuthorDto;
import com.berezanskiy.books.entities.Author;
import com.berezanskiy.books.entities.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("bookDtoConverter")
public class BookDtoConverter implements Converter<Book, BookDto> {

    @Autowired
    @Qualifier("embeddableAuthorDtoConverter")
    private Converter<Author, EmbeddableAuthorDto> converter;

    @Override
    public BookDto convert(Book book) {
        return BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .authors(converter.convertAll(book.getAuthors()))
                .build();
    }
}
