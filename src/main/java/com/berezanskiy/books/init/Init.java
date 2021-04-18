package com.berezanskiy.books.init;

import com.berezanskiy.books.entities.Author;
import com.berezanskiy.books.entities.Book;
import com.berezanskiy.books.repositories.AuthorRepository;
import com.berezanskiy.books.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class Init {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @EventListener
    public void init(ApplicationReadyEvent event) {
        Book book1 = Book.builder()
                .name("Angels & Demons")
                .build();
        Book book2 = Book.builder()
                .name("The Da Vinci Code")
                .build();
        Book book3 = Book.builder()
                .name("Good Omens")
                .build();
        bookRepository.saveAll(new ArrayList<>(
                Arrays.asList(
                        book1,
                        book2,
                        book3
                )
        ));

        authorRepository.saveAll(new ArrayList<>(
                Arrays.asList(
                        Author.builder()
                                .penName("Neil Gaiman")
                                .firstName("Neil")
                                .surname("Gaiman")
                                .books(new ArrayList<>(Arrays.asList(book3)))
                                .build(),
                        Author.builder()
                                .penName("Terry Pratchett")
                                .firstName("Terry")
                                .surname("Pratchett")
                                .books(new ArrayList<>(Arrays.asList(book3)))
                                .build(),
                        Author.builder()
                                .penName("Dan Brown")
                                .firstName("Dan")
                                .surname("Brown")
                                .books(new ArrayList<>(Arrays.asList(book1, book2)))
                                .build()
                )
        ));
    }
}
