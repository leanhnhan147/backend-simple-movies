package com.example.backendsimplemovies.service.impl;

import com.example.backendsimplemovies.dto.Movie.MovieDto;
import com.example.backendsimplemovies.dto.ResponseListDto;
import com.example.backendsimplemovies.entity.Movie;
import com.example.backendsimplemovies.entity.criteria.MovieCriteria;
import com.example.backendsimplemovies.exception.NotFoundException;
import com.example.backendsimplemovies.form.movie.CreateMovieForm;
import com.example.backendsimplemovies.form.movie.UpdateMovieForm;
import com.example.backendsimplemovies.mapper.MovieMapper;
import com.example.backendsimplemovies.repository.MovieRepository;
import com.example.backendsimplemovies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    MovieMapper movieMapper;

    @Override
    public MovieDto getMovieById(long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found movie"));
        return movieMapper.fromEntityToAdminDto(movie);
    }

    @Override
    public ResponseListDto<List<MovieDto>> getAllMovie(MovieCriteria movieCriteria, Pageable pageable) {
        Page<Movie> moviePage =movieRepository.findAll(movieCriteria.getSpecification(), pageable);
        ResponseListDto<List<MovieDto>> responseListDto = new ResponseListDto<>();
        responseListDto.setResults(movieMapper.fromEntityListToMovieDtoList(moviePage.getContent()));
        responseListDto.setPage(pageable.getPageNumber());
        responseListDto.setTotal_pages(moviePage.getTotalPages());
        responseListDto.setTotal_results(moviePage.getTotalElements());

        return responseListDto;
    }

    @Override
    public MovieDto createMovie(CreateMovieForm createMovieForm) {
    Movie movie = movieMapper.fromCreateMovieFormToEntity(createMovieForm);
    movieRepository.save(movie);
        return movieMapper.fromEntityToAdminDto(movie);
    }

    @Override
    public MovieDto updateMovie(UpdateMovieForm updateMovieForm) {
        Movie movie = movieRepository.findById(updateMovieForm.getId())
                .orElseThrow(() -> new NotFoundException("Not found movie"));
        movieMapper.fromUpdateMovieFormToEntity(updateMovieForm, movie);
        movieRepository.save(movie);
        return movieMapper.fromEntityToAdminDto(movie);
    }

    @Override
    public void deleteMovie(long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found movie"));
        movie.setStatus(0);
        movieRepository.save(movie);
    }
}
