package com.berezanskiy.books.controllers;

import com.berezanskiy.books.converters.Converter;
import com.berezanskiy.books.dtos.AuthorDto;
import com.berezanskiy.books.entities.Author;
import com.berezanskiy.books.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    @Qualifier("authorDtoConverter")
    private Converter<Author, AuthorDto> authorDtoConverter;

    @GetMapping
    public List<AuthorDto> getAllAuthors() {
        return authorDtoConverter.convertAll(authorService.getAllAuthors());
    }
}
