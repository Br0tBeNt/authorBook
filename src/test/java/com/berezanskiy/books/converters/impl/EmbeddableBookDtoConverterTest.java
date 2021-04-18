package com.berezanskiy.books.converters.impl;

import com.berezanskiy.books.dtos.EmbeddableBookDto;
import com.berezanskiy.books.entities.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class EmbeddableBookDtoConverterTest {

    @InjectMocks
    private EmbeddableBookDtoConverter converter;

    @Test
    public void shouldReturnConverterBookToEmbeddableBookDto() {
        Book book = Book.builder()
                .id(1L)
                .name("Angels & Demons")
                .build();

        EmbeddableBookDto expectedResult = EmbeddableBookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .build();

        EmbeddableBookDto actualResult = converter.convert(book);

        assertEquals(expectedResult, actualResult);
    }
}