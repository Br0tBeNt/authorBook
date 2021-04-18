package com.berezanskiy.books.converters.impl;

import com.berezanskiy.books.dtos.BookDto;
import com.berezanskiy.books.entities.Author;
import com.berezanskiy.books.entities.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BookDtoConverterTest {

    @InjectMocks
    private BookDtoConverter bookDtoConverter;

    @Spy
    private EmbeddableAuthorDtoConverter embeddableAuthorDtoConverter;

    @Test
    public void shouldReturnConverterBookToBookDto() {
        Book book = Book.builder()
                .id(1L)
                .name("Angels & Demons")
                .authors(new ArrayList<>(Arrays.asList(
                        Author.builder()
                                .id(5L)
                                .penName("Neil Gaiman")
                                .firstName("Neil")
                                .surname("Gaiman")
                                .build())))
                .build();

        BookDto expectedResult = BookDto.builder()
                .id(book.getId())
                .name(book.getName())
                .authors(embeddableAuthorDtoConverter.convertAll(book.getAuthors()))
                .build();

        BookDto actualResult = bookDtoConverter.convert(book);

        assertEquals(expectedResult, actualResult);
    }
}