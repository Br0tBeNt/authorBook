package com.berezanskiy.books.services.impl;

import com.berezanskiy.books.entities.Book;
import com.berezanskiy.books.repositories.BookRepository;
import com.berezanskiy.books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
