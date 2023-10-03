package com.example.backendsimplemovies.service;

import com.example.backendsimplemovies.dto.ResponseListDto;
import com.example.backendsimplemovies.dto.genre.GenreDto;
import com.example.backendsimplemovies.dto.video.VideoDto;
import com.example.backendsimplemovies.entity.criteria.GenreCriteria;
import com.example.backendsimplemovies.entity.criteria.VideoCriteria;
import com.example.backendsimplemovies.form.genre.CreateGenreForm;
import com.example.backendsimplemovies.form.genre.UpdateGenreForm;
import com.example.backendsimplemovies.form.video.CreateVideoForm;
import com.example.backendsimplemovies.form.video.UpdateVideoForm;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface VideoService {
    VideoDto getVideoById(long id);

    ResponseListDto<List<VideoDto>> getAllVideo(VideoCriteria videoCriteria, Pageable pageable);

    VideoDto createVideo(CreateVideoForm createVideoForm);

    VideoDto updateVideo(UpdateVideoForm updateVideoForm);

    void deleteVideo(long id);

    List<VideoDto> getVideoByMovieId(long movieId);
}
