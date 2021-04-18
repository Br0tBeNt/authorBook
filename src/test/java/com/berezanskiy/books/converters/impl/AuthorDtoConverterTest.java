package com.berezanskiy.books.converters.impl;

import com.berezanskiy.books.dtos.AuthorDto;
import com.berezanskiy.books.entities.Author;
import com.berezanskiy.books.entities.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class AuthorDtoConverterTest {

    @InjectMocks
    private AuthorDtoConverter authorDtoConverter;

    @Spy
    private EmbeddableBookDtoConverter embeddableBookDtoConverter;

    @Test
    public void shouldReturnConverterAuthorToAuthorDto() {
        Author author = Author.builder()
                .id(5L)
                .penName("Neil Gaiman")
                .firstName("Neil")
                .surname("Gaiman")
                .books(Collections.singletonList(
                        Book.builder()
                                .id(1L)
                                .name("Angels & Demons")
                                .build()))
                .build();

        AuthorDto expectedResult = AuthorDto.builder()
                .id(author.getId())
                .penName(author.getPenName())
                .firstName(author.getFirstName())
                .surname(author.getSurname())
                .books(embeddableBookDtoConverter.convertAll(author.getBooks()))
                .build();

        AuthorDto actualResult = authorDtoConverter.convert(author);

        assertEquals(expectedResult, actualResult);
    }
}