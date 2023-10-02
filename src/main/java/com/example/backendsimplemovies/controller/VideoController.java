package com.example.backendsimplemovies.controller;

import com.example.backendsimplemovies.dto.ApiMessageDto;
import com.example.backendsimplemovies.dto.ResponseListDto;
import com.example.backendsimplemovies.dto.genre.GenreDto;
import com.example.backendsimplemovies.dto.video.VideoDto;
import com.example.backendsimplemovies.entity.criteria.GenreCriteria;
import com.example.backendsimplemovies.entity.criteria.VideoCriteria;
import com.example.backendsimplemovies.form.genre.CreateGenreForm;
import com.example.backendsimplemovies.form.genre.UpdateGenreForm;
import com.example.backendsimplemovies.form.video.CreateVideoForm;
import com.example.backendsimplemovies.form.video.UpdateVideoForm;
import com.example.backendsimplemovies.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/video")
public class VideoController {

    @Autowired
    VideoService videoService;

    @GetMapping(value = "/get/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiMessageDto<VideoDto> getVideoById(@PathVariable long id){
        ApiMessageDto<VideoDto> apiMessageDto = new ApiMessageDto<>();
        apiMessageDto.setData(videoService.getVideoById(id));
        apiMessageDto.setMessage("Get video success");
        return apiMessageDto;
    }

    @GetMapping(value = "/getAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseListDto<?> getAllVideo(VideoCriteria videoCriteria, Pageable pageable){
        return videoService.getAllVideo(videoCriteria, pageable);
    }

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiMessageDto<?> createVideo(@Valid @RequestBody CreateVideoForm createVideoForm, BindingResult bindingResult){
        ApiMessageDto<?> apiMessageDto = new ApiMessageDto<>();
        videoService.createVideo(createVideoForm);
        apiMessageDto.setMessage("Create video success");
        return apiMessageDto;
    }

    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiMessageDto<?> updateVideo(@Valid @RequestBody UpdateVideoForm updateVideoForm, BindingResult bindingResult){
        ApiMessageDto<?> apiMessageDto = new ApiMessageDto<>();
        videoService.updateVideo(updateVideoForm);
        apiMessageDto.setMessage("Update video success");
        return apiMessageDto;
    }

    @DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ApiMessageDto<?> deleteVideo(@PathVariable long id){
        ApiMessageDto<?> apiMessageDto = new ApiMessageDto<>();
        videoService.deleteVideo(id);
        apiMessageDto.setMessage("Delete video success");
        return apiMessageDto;
    }
}
