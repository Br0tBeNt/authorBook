package com.berezanskiy.books.repositories;

import com.berezanskiy.books.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    /**
     * Gets book by name
     *
     * @param name  to search book by
     *
     * @return optional of book by name
     */
    Optional<Book> findBookByName(String name);
}
