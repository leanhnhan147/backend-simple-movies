package com.example.backendsimplemovies.service.impl;

import com.example.backendsimplemovies.dto.Movie.MovieDto;
import com.example.backendsimplemovies.dto.ResponseListDto;
import com.example.backendsimplemovies.entity.Cast;
import com.example.backendsimplemovies.entity.Genre;
import com.example.backendsimplemovies.entity.Movie;
import com.example.backendsimplemovies.entity.criteria.MovieCriteria;
import com.example.backendsimplemovies.exception.NotFoundException;
import com.example.backendsimplemovies.form.movie.CreateMovieForm;
import com.example.backendsimplemovies.form.movie.UpdateMovieForm;
import com.example.backendsimplemovies.mapper.MovieMapper;
import com.example.backendsimplemovies.repository.CastRepository;
import com.example.backendsimplemovies.repository.GenreRepository;
import com.example.backendsimplemovies.repository.MovieRepository;
import com.example.backendsimplemovies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    CastRepository castRepository;

    @Autowired
    MovieMapper movieMapper;

    @Override
    public MovieDto getMovieById(long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found movie"));
        return movieMapper.fromEntityToAdminDto(movie);
    }

    @Override
    public ResponseListDto<List<MovieDto>> getAllMovie(MovieCriteria movieCriteria, Pageable pageable, String type) {
        ResponseListDto<List<MovieDto>> responseListDto = new ResponseListDto<>();
        List<Movie> movies = new ArrayList<>();

        if(type.equals("now_playing")) {
            Page<Movie> moviePage = movieRepository.findAll(movieCriteria.getSpecification(), pageable);
            responseListDto.setResults(movieMapper.fromEntityListToMovieDtoList(moviePage.getContent()));
            responseListDto.setPage(pageable.getPageNumber());
            responseListDto.setTotal_pages(moviePage.getTotalPages());
            responseListDto.setTotal_results(moviePage.getTotalElements());
        }else if(type.equals("top_rated")){
            movies = movieRepository.findByOrderByVoteAverageDesc();
            responseListDto.setResults(movieMapper.fromEntityListToMovieDtoList(movies));
        }else if(type.equals("popular")){
            movies = movieRepository.findByOrderByPopularityDesc();
            responseListDto.setResults(movieMapper.fromEntityListToMovieDtoList(movies));
        }
        return responseListDto;
    }

    @Override
    public MovieDto createMovie(CreateMovieForm createMovieForm) {
        Movie movie = movieMapper.fromCreateMovieFormToEntity(createMovieForm);

        List<Genre> genres = new ArrayList<>();
        for(int i = 0; i< createMovieForm.getGenres().length;i++){
            Genre genre = genreRepository.findById(createMovieForm.getGenres()[i]).orElse(null);
            if(genre != null){
                genres.add(genre);
            }
        }
        List<Cast> casts = new ArrayList<>();
        for(int i = 0; i< createMovieForm.getCasts().length;i++){
            Cast cast = castRepository.findById(createMovieForm.getCasts()[i]).orElse(null);
            if(cast != null){
                casts.add(cast);
            }
        }

        movie.setGenres(genres);
        movie.setCasts(casts);
        movieRepository.save(movie);
        return movieMapper.fromEntityToAdminDto(movie);
    }

    @Override
    public MovieDto updateMovie(UpdateMovieForm updateMovieForm) {
        Movie movie = movieRepository.findById(updateMovieForm.getId())
                .orElseThrow(() -> new NotFoundException("Not found movie"));
        movieMapper.fromUpdateMovieFormToEntity(updateMovieForm, movie);
        List<Genre> genres = new ArrayList<>();
        for(int i = 0; i< updateMovieForm.getGenres().length;i++){
            Genre genre = genreRepository.findById(updateMovieForm.getGenres()[i]).orElse(null);
            if(genre != null){
                genres.add(genre);
            }
        }
        List<Cast> casts = new ArrayList<>();
        for(int i = 0; i< updateMovieForm.getCasts().length;i++){
            Cast cast = castRepository.findById(updateMovieForm.getCasts()[i]).orElse(null);
            if(cast != null){
                casts.add(cast);
            }
        }
        movie.setGenres(genres);
        movie.setCasts(casts);
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
