package com.berezanskiy.books.converters;

import java.util.List;
import java.util.stream.Collectors;

/**
 *  Used for transformation from Entity to DTO and backwards. Actually you can use it to transform any objects.
 *
 * @param <FROM>> the FROM class
 *
 * @param <TO> the TO class
 */
public interface Converter<FROM, TO> {

    TO convert(FROM from);

    default List<TO> convertAll(List<FROM> list) {
        return list.stream().map(this::convert).collect(Collectors.toList());
    }
}
