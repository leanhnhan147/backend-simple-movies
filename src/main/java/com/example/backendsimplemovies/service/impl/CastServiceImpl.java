package com.example.backendsimplemovies.service.impl;

import com.example.backendsimplemovies.dto.ResponseListDto;
import com.example.backendsimplemovies.dto.cast.CastDto;
import com.example.backendsimplemovies.dto.genre.GenreDto;
import com.example.backendsimplemovies.entity.Cast;
import com.example.backendsimplemovies.entity.Genre;
import com.example.backendsimplemovies.entity.criteria.CastCriteria;
import com.example.backendsimplemovies.exception.NotFoundException;
import com.example.backendsimplemovies.form.cast.CreateCastForm;
import com.example.backendsimplemovies.form.cast.UpdateCastForm;
import com.example.backendsimplemovies.mapper.CastMapper;
import com.example.backendsimplemovies.repository.CastRepository;
import com.example.backendsimplemovies.service.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CastServiceImpl implements CastService {

    @Autowired
    CastRepository castRepository;

    @Autowired
    CastMapper castMapper;

    @Override
    public CastDto getCastById(long id) {
        Cast cast = castRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found cast"));
        return castMapper.fromEntityToAdminDto(cast);
    }

    @Override
    public ResponseListDto<List<CastDto>> getAllCast(CastCriteria castCriteria, Pageable pageable) {
        Page<Cast> castPage = castRepository.findAll(castCriteria.getSpecification(), pageable);
        ResponseListDto<List<CastDto>> responseListDto = new ResponseListDto<>();
        responseListDto.setResults(castMapper.fromEntityListToCastDtoList(castPage.getContent()));
        responseListDto.setPage(pageable.getPageNumber());
        responseListDto.setTotal_pages(castPage.getTotalPages());
        responseListDto.setTotal_results(castPage.getTotalElements());

        return responseListDto;
    }

    @Override
    public CastDto createCast(CreateCastForm createCastForm) {
        Cast cast = castMapper.fromCreateCastFormToEntity(createCastForm);
        castRepository.save(cast);
        return castMapper.fromEntityToAdminDto(cast);

    }

    @Override
    public CastDto updateCast(UpdateCastForm updateCastForm) {
        Cast cast = castRepository.findById(updateCastForm.getId())
                .orElseThrow(() -> new NotFoundException("Not found cast"));
        castMapper.fromUpdateCastFormtoEntity(updateCastForm, cast);
        castRepository.save(cast);
        return castMapper.fromEntityToAdminDto(cast);
    }

    @Override
    public void deleteCast(long id) {
        Cast cast = castRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found cast"));
        cast.setStatus(0);
        castRepository.save(cast);
    }
}
