package com.example.backendsimplemovies.controller;

import com.example.backendsimplemovies.dto.ApiMessageDto;
import com.example.backendsimplemovies.dto.ResponseListDto;
import com.example.backendsimplemovies.dto.cast.CastDto;
import com.example.backendsimplemovies.entity.criteria.CastCriteria;
import com.example.backendsimplemovies.form.cast.CreateCastForm;
import com.example.backendsimplemovies.form.cast.UpdateCastForm;
import com.example.backendsimplemovies.service.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/cast")
public class CastController {

    @Autowired
    CastService castService;

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiMessageDto<CastDto> getCastById(@PathVariable long id){
        ApiMessageDto<CastDto> apiMessageDto = new ApiMessageDto<>();
        apiMessageDto.setData(castService.getCastById(id));
        apiMessageDto.setMessage("Get cast success");
        return apiMessageDto;
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseListDto<?> getAllCast(CastCriteria castCriteria, Pageable pageable){
        return castService.getAllCast(castCriteria, pageable);
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiMessageDto<?> createCast(@Valid @RequestBody CreateCastForm createCastForm, BindingResult bindingResult){
        ApiMessageDto<?> apiMessageDto = new ApiMessageDto<>();
        castService.createCast(createCastForm);
        apiMessageDto.setMessage("Create cast success");
        return apiMessageDto;
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiMessageDto<?> updateCast(@Valid @RequestBody UpdateCastForm updateCastForm, BindingResult bindingResult){
        ApiMessageDto<?> apiMessageDto = new ApiMessageDto<>();
        castService.updateCast(updateCastForm);
        apiMessageDto.setMessage("Update cast success");
        return apiMessageDto;
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiMessageDto<?> deleteCast(@PathVariable long id){
        ApiMessageDto<?> apiMessageDto = new ApiMessageDto<>();
        castService.deleteCast(id);
        apiMessageDto.setMessage("Delete cast success");
        return apiMessageDto;
    }
}
