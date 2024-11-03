package com.example.Library.mapper;

import com.example.Library.model.Book;
import com.example.Library.model.BookDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    @Mapping(source = "book", target = ".")
    BookDTO mapToBookDTO (Book book);

    @InheritInverseConfiguration(name = "mapToBookDTO")
    Book mapToBook (BookDTO bookDTO);

    @Mapping(source = "book", target = ".")
    List<BookDTO> mapToBookDTOList (List<Book> books);
}
