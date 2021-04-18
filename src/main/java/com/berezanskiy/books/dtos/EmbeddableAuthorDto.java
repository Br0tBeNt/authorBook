package com.berezanskiy.books.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmbeddableAuthorDto {
    private Long id;
    private String penName;
    private String firstName;
    private String surname;
}
