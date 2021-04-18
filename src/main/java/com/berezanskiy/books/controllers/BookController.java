package com.berezanskiy.books.controllers;

import com.berezanskiy.books.converters.Converter;
import com.berezanskiy.books.dtos.BookDto;
import com.berezanskiy.books.entities.Book;
import com.berezanskiy.books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    @Qualifier("bookDtoConverter")
    private Converter<Book, BookDto> bookDtoConverter;

    @GetMapping
    public List<BookDto> getAllBooks() {
        return bookDtoConverter.convertAll(bookService.getAllBooks());
    }
}
