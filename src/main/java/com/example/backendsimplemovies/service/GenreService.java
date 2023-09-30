package com.example.backendsimplemovies.service;

import com.example.backendsimplemovies.dto.ResponseListDto;
import com.example.backendsimplemovies.dto.genre.GenreDto;
import com.example.backendsimplemovies.entity.criteria.GenreCriteria;
import com.example.backendsimplemovies.form.genre.CreateGenreForm;
import com.example.backendsimplemovies.form.genre.UpdateGenreForm;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenreService {

    GenreDto getGenreById(long id);

    ResponseListDto<List<GenreDto>> getAllGenre(GenreCriteria genreCriteria, Pageable pageable);

    GenreDto createGenre(CreateGenreForm createGenreForm);

    GenreDto updateGenre(UpdateGenreForm updateGenreForm);

    void deleteGenre(long id);
}
