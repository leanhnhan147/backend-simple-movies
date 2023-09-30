package com.example.backendsimplemovies.service;

import com.example.backendsimplemovies.dto.ResponseListDto;
import com.example.backendsimplemovies.dto.cast.CastDto;
import com.example.backendsimplemovies.dto.genre.GenreDto;
import com.example.backendsimplemovies.entity.criteria.CastCriteria;
import com.example.backendsimplemovies.entity.criteria.GenreCriteria;
import com.example.backendsimplemovies.form.cast.CreateCastForm;
import com.example.backendsimplemovies.form.cast.UpdateCastForm;
import com.example.backendsimplemovies.form.genre.CreateGenreForm;
import com.example.backendsimplemovies.form.genre.UpdateGenreForm;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CastService {
    CastDto getCastById(long id);

    ResponseListDto<List<CastDto>> getAllCast(CastCriteria criteria, Pageable pageable);

    CastDto createCast(CreateCastForm createCastForm);

    CastDto updateCast(UpdateCastForm updateCastForm);

    void deleteCast(long id);
}
