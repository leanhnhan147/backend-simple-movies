package com.example.backendsimplemovies.service;

import com.example.backendsimplemovies.dto.Movie.MovieDto;
import com.example.backendsimplemovies.dto.ResponseListDto;
import com.example.backendsimplemovies.entity.criteria.MovieCriteria;
import com.example.backendsimplemovies.form.movie.CreateMovieForm;
import com.example.backendsimplemovies.form.movie.UpdateMovieForm;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface MovieService {

    MovieDto getMovieById(long id);

    ResponseListDto<List<MovieDto>> getAllMovie(MovieCriteria movieCriteria, Pageable pageable, String type);

    MovieDto createMovie(CreateMovieForm createMovieForm);

    MovieDto updateMovie(UpdateMovieForm updateMovieForm);

    void deleteMovie(long id);
}
