package com.example.backendsimplemovies.controller;

import com.example.backendsimplemovies.dto.ApiMessageDto;
import com.example.backendsimplemovies.dto.Movie.MovieDto;
import com.example.backendsimplemovies.dto.ResponseListDto;
import com.example.backendsimplemovies.dto.genre.GenreDto;
import com.example.backendsimplemovies.entity.criteria.GenreCriteria;
import com.example.backendsimplemovies.entity.criteria.MovieCriteria;
import com.example.backendsimplemovies.form.genre.CreateGenreForm;
import com.example.backendsimplemovies.form.genre.UpdateGenreForm;
import com.example.backendsimplemovies.form.movie.CreateMovieForm;
import com.example.backendsimplemovies.form.movie.UpdateMovieForm;
import com.example.backendsimplemovies.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/genre")
public class GenreController {

    @Autowired
    GenreService genreService;

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiMessageDto<GenreDto> getGenreById(@PathVariable long id){
        ApiMessageDto<GenreDto> apiMessageDto = new ApiMessageDto<>();
        apiMessageDto.setData(genreService.getGenreById(id));
        apiMessageDto.setMessage("Get genre success");
        return apiMessageDto;
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseListDto<?> getAllGenre(GenreCriteria genreCriteria, Pageable pageable){
        return genreService.getAllGenre(genreCriteria, pageable);
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiMessageDto<?> createGenre(@Valid @RequestBody CreateGenreForm createGenreForm, BindingResult bindingResult){
        ApiMessageDto<?> apiMessageDto = new ApiMessageDto<>();
        genreService.createGenre(createGenreForm);
        apiMessageDto.setMessage("Create genre success");
        return apiMessageDto;
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiMessageDto<?> updateGenre(@Valid @RequestBody UpdateGenreForm updateGenreForm, BindingResult bindingResult){
        ApiMessageDto<?> apiMessageDto = new ApiMessageDto<>();
        genreService.updateGenre(updateGenreForm);
        apiMessageDto.setMessage("Update genre success");
        return apiMessageDto;
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiMessageDto<?> deleteGenre(@PathVariable long id){
        ApiMessageDto<?> apiMessageDto = new ApiMessageDto<>();
        genreService.deleteGenre(id);
        apiMessageDto.setMessage("Delete genre success");
        return apiMessageDto;
    }
}
