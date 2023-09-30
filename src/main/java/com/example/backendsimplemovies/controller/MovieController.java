package com.example.backendsimplemovies.controller;

import com.example.backendsimplemovies.dto.ApiMessageDto;
import com.example.backendsimplemovies.dto.Movie.MovieDto;
import com.example.backendsimplemovies.dto.ResponseListDto;
import com.example.backendsimplemovies.entity.criteria.MovieCriteria;
import com.example.backendsimplemovies.form.movie.CreateMovieForm;
import com.example.backendsimplemovies.form.movie.UpdateMovieForm;
import com.example.backendsimplemovies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/movie")
public class MovieController {

    @Autowired
    MovieService  movieService;

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiMessageDto<MovieDto> getMovieById(@PathVariable long id){
        ApiMessageDto<MovieDto> apiMessageDto = new ApiMessageDto<>();
        apiMessageDto.setData(movieService.getMovieById(id));
        apiMessageDto.setMessage("Get movie success");
        return apiMessageDto;
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseListDto<?> getAllMovie(MovieCriteria movieCriteria, Pageable pageable){
        return movieService.getAllMovie(movieCriteria, pageable);
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiMessageDto<?> createMovie(@Valid @RequestBody CreateMovieForm createMovieForm, BindingResult bindingResult){
        ApiMessageDto<?> apiMessageDto = new ApiMessageDto<>();
        movieService.createMovie(createMovieForm);
        apiMessageDto.setMessage("Create movie success");
        return apiMessageDto;
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiMessageDto<?> updateMovie(@Valid @RequestBody UpdateMovieForm updateMovieForm, BindingResult bindingResult){
        ApiMessageDto<?> apiMessageDto = new ApiMessageDto<>();
        movieService.updateMovie(updateMovieForm);
        apiMessageDto.setMessage("Update movie success");
        return apiMessageDto;
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiMessageDto<?> deleteMovie(@PathVariable long id){
        ApiMessageDto<?> apiMessageDto = new ApiMessageDto<>();
        movieService.deleteMovie(id);
        apiMessageDto.setMessage("Delete movie success");
        return apiMessageDto;
    }
}
