package com.berezanskiy.books.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthorDto {
    private Long id;
    private String penName;
    private String firstName;
    private String surname;
    private List<EmbeddableBookDto> books;
}
