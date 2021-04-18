package com.berezanskiy.books.services.impl;

import com.berezanskiy.books.entities.Author;
import com.berezanskiy.books.repositories.AuthorRepository;
import com.berezanskiy.books.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAllAuthors(){
        return authorRepository.findAll();
    }
}
