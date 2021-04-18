package com.berezanskiy.books.services.impl;

import com.berezanskiy.books.entities.Author;
import com.berezanskiy.books.repositories.AuthorRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AuthorServiceImplTest {
    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorServiceImpl authorService;

    @Test
    public void shouldReturnAllAuthors() {
        List<Author> authors = new ArrayList<>(Arrays.asList(
                Author.builder()
                        .penName("Neil Gaiman")
                        .firstName("Neil")
                        .surname("Gaiman")
                        .build(),
                Author.builder()
                        .penName("Terry Pratchett")
                        .firstName("Terry")
                        .surname("Pratchett")
                        .build()
        ));

        when(authorRepository.findAll()).thenReturn(authors);

        List<Author> actualResult = authorService.getAllAuthors();
        assertEquals(authors, actualResult);
    }
}