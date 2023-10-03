package com.example.backendsimplemovies.mapper;

import com.example.backendsimplemovies.dto.genre.GenreDto;
import com.example.backendsimplemovies.entity.Genre;
import com.example.backendsimplemovies.form.genre.CreateGenreForm;
import com.example.backendsimplemovies.form.genre.UpdateGenreForm;
import org.mapstruct.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface GenreMapper {

    @Mapping(source = "genreName", target = "name")
    @BeanMapping(ignoreByDefault = true)
    @Named("adminCreateMapping")
    Genre fromCreateGenreFormToEntity(CreateGenreForm createGenreForm);

    @Mapping(source = "genreName", target = "name")
    @Mapping(source = "status", target = "status")
    @BeanMapping(ignoreByDefault = true)
    @Named("adminUpdateMapping")
    void fromUpdateGenreFormtoEntity(UpdateGenreForm updateGenreForm, @MappingTarget Genre genre);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "genreName")
    @Mapping(source = "createdDate", target = "createdDate")
    @Mapping(source = "modifiedDate", target = "modifiedDate")
    @Mapping(source = "status", target = "status")
    @BeanMapping(ignoreByDefault = true)
    @Named("adminGetMapping")
    GenreDto fromEntityToAdminDto(Genre genre);

    @IterableMapping(elementTargetType = GenreDto.class, qualifiedByName = "adminGetMapping")
    List<GenreDto> fromEntityListToGenreDtoList(List<Genre> genres);

//    @Mapping(source = "id", target = "id")
//    @Mapping(source = "name", target = "genreName")
//    @BeanMapping(ignoreByDefault = true)
//    @Named("genreGetMapping")
//    GenreDto fromEntityToDto(Genre genre);
//
//    @IterableMapping(elementTargetType = GenreDto.class, qualifiedByName = "genreGetMapping")
//    @Named("genresGetMapping")
//    List<GenreDto> fromEntityListToDtoList(List<Genre> genres);
}
