package com.berezanskiy.books.repositories;

import com.berezanskiy.books.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository  extends JpaRepository<Author, Long> {

    /**
     * Gets author by pen name
     *
     * @param penName to search author by
     *
     * @return optional of author by pen name
     */
    Optional<Author> findAuthorByPenName(String penName);
}
