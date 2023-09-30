package com.example.backendsimplemovies.service.impl;

import com.example.backendsimplemovies.dto.ResponseListDto;
import com.example.backendsimplemovies.dto.genre.GenreDto;
import com.example.backendsimplemovies.entity.Genre;
import com.example.backendsimplemovies.entity.criteria.GenreCriteria;
import com.example.backendsimplemovies.exception.NotFoundException;
import com.example.backendsimplemovies.form.genre.CreateGenreForm;
import com.example.backendsimplemovies.form.genre.UpdateGenreForm;
import com.example.backendsimplemovies.mapper.GenreMapper;
import com.example.backendsimplemovies.repository.GenreRepository;
import com.example.backendsimplemovies.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService {

    @Autowired
    GenreRepository genreRepository;

    @Autowired
    GenreMapper genreMapper;

    @Override
    public GenreDto getGenreById(long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found genre"));
        return genreMapper.fromEntityToAdminDto(genre);
    }

    @Override
    public ResponseListDto<List<GenreDto>> getAllGenre(GenreCriteria genreCriteria, Pageable pageable) {
        Page<Genre> genrePage = genreRepository.findAll(genreCriteria.getSpecification(), pageable);
        ResponseListDto<List<GenreDto>> responseListDto = new ResponseListDto<>();
        responseListDto.setResults(genreMapper.fromEntityListToGenreDtoList(genrePage.getContent()));
        responseListDto.setPage(pageable.getPageNumber());
        responseListDto.setTotal_pages(genrePage.getTotalPages());
        responseListDto.setTotal_results(genrePage.getTotalElements());

        return responseListDto;
    }

    @Override
    public GenreDto createGenre(CreateGenreForm createGenreForm) {
        Genre genre = genreMapper.fromCreateGenreFormToEntity(createGenreForm);
        genreRepository.save(genre);
        return genreMapper.fromEntityToAdminDto(genre);
    }

    @Override
    public GenreDto updateGenre(UpdateGenreForm updateGenreForm) {
        Genre genre = genreRepository.findById(updateGenreForm.getId())
                .orElseThrow(() -> new NotFoundException("Not found genre"));
        genreMapper.fromUpdateGenreFormtoEntity(updateGenreForm, genre);
        genreRepository.save(genre);
        return genreMapper.fromEntityToAdminDto(genre);
    }

    @Override
    public void deleteGenre(long id) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found genre"));
        genre.setStatus(0);
        genreRepository.save(genre);
    }
}
