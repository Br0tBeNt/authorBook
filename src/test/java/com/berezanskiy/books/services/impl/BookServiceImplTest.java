package com.berezanskiy.books.services.impl;

import com.berezanskiy.books.entities.Book;
import com.berezanskiy.books.repositories.BookRepository;
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
public class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    public void shouldReturnAllBooks() {
        List<Book> books = new ArrayList<>(Arrays.asList(
                Book.builder()
                        .name("Angels & Demons")
                        .build(),

                Book.builder()
                        .name("Inferno")
                        .build()
                ));

        when(bookRepository.findAll()).thenReturn(books);

        List<Book> actualResult = bookService.getAllBooks();
        assertEquals(books, actualResult);
    }
}