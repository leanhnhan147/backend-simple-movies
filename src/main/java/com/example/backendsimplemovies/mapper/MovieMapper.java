package com.example.backendsimplemovies.mapper;

import com.example.backendsimplemovies.dto.Movie.MovieDto;
import com.example.backendsimplemovies.entity.Movie;
import com.example.backendsimplemovies.form.movie.CreateMovieForm;
import com.example.backendsimplemovies.form.movie.UpdateMovieForm;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface MovieMapper {

    @Mapping(source = "title", target = "title")
    @Mapping(source = "overview", target = "overview")
    @Mapping(source = "poster_path", target = "posterPath")
    @Mapping(source = "backdrop_path", target = "backdropPath")
    @Mapping(source = "popularity", target = "popularity")
    @Mapping(source = "vote_average", target = "voteAverage")
    @Mapping(source = "vote_count", target = "voteCount")
    @Mapping(source = "release_date", target = "releaseDate")
    @BeanMapping(ignoreByDefault = true)
    @Named("adminCreateMapping")
    Movie fromCreateMovieFormToEntity(CreateMovieForm createMovieForm);

    @Mapping(source = "title", target = "title")
    @Mapping(source = "overview", target = "overview")
    @Mapping(source = "poster_path", target = "posterPath")
    @Mapping(source = "backdrop_path", target = "backdropPath")
    @Mapping(source = "status", target = "status")
    @BeanMapping(ignoreByDefault = true)
    @Named("adminUpdateMapping")
    void fromUpdateMovieFormToEntity(UpdateMovieForm updateMovieForm, @MappingTarget Movie movie);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "overview", target = "overview")
    @Mapping(source = "posterPath", target = "poster_path")
    @Mapping(source = "backdropPath", target = "backdrop_path")
    @Mapping(source = "popularity", target = "popularity")
    @Mapping(source = "voteAverage", target = "vote_average")
    @Mapping(source = "voteCount", target = "vote_count")
    @Mapping(source = "releaseDate", target = "release_date")
    @Mapping(source = "createdDate", target = "createdDate")
    @Mapping(source = "modifiedDate", target = "modifiedDate")
    @Mapping(source = "status", target = "status")
    @BeanMapping(ignoreByDefault = true)
    @Named("adminGetMapping")
    MovieDto fromEntityToAdminDto(Movie movie);

    @IterableMapping(elementTargetType = MovieDto.class, qualifiedByName = "adminGetMapping")
    List<MovieDto> fromEntityListToMovieDtoList(List<Movie> movies);


}
