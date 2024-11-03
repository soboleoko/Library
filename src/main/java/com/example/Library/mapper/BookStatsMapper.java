package com.example.Library.mapper;

import com.example.Library.model.BookStats;
import com.example.Library.model.BookStatsDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookStatsMapper {
    @Mapping(source = "bookStats", target = ".")
    BookStatsDTO mapToBookStatsDTO (BookStats bookStats);

    @InheritInverseConfiguration
    BookStats mapToBookStatsDTO (BookStatsDTO bookStatsDTO);
}
