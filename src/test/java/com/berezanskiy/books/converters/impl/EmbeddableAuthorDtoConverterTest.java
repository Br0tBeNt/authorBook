package com.berezanskiy.books.converters.impl;

import com.berezanskiy.books.dtos.EmbeddableAuthorDto;
import com.berezanskiy.books.entities.Author;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class EmbeddableAuthorDtoConverterTest {

    @InjectMocks
    private EmbeddableAuthorDtoConverter converter;

    @Test
    public void shouldReturnConverterAuthorToEmbeddableAuthorDto() {
        Author author = Author.builder()
                .id(5L)
                .penName("Neil Gaiman")
                .firstName("Neil")
                .surname("Gaiman")
                .build();

        EmbeddableAuthorDto expectedResult = EmbeddableAuthorDto.builder()
                .id(author.getId())
                .penName(author.getPenName())
                .firstName(author.getFirstName())
                .surname(author.getSurname())
                .build();

        EmbeddableAuthorDto actualResult = converter.convert(author);

        assertEquals(expectedResult, actualResult);
    }
}