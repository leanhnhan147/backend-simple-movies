package com.example.backendsimplemovies.service.impl;

import com.example.backendsimplemovies.dto.ResponseListDto;
import com.example.backendsimplemovies.dto.video.VideoDto;
import com.example.backendsimplemovies.entity.Movie;
import com.example.backendsimplemovies.entity.Video;
import com.example.backendsimplemovies.entity.criteria.VideoCriteria;
import com.example.backendsimplemovies.exception.NotFoundException;
import com.example.backendsimplemovies.form.video.CreateVideoForm;
import com.example.backendsimplemovies.form.video.UpdateVideoForm;
import com.example.backendsimplemovies.mapper.VideoMapper;
import com.example.backendsimplemovies.repository.MovieRepository;
import com.example.backendsimplemovies.repository.VideoRepository;
import com.example.backendsimplemovies.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    VideoRepository videoRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    VideoMapper videoMapper;

    @Override
    public VideoDto getVideoById(long id) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found video"));
        return videoMapper.fromEntityToAdminDto(video);
    }

    @Override
    public ResponseListDto<List<VideoDto>> getAllVideo(VideoCriteria videoCriteria, Pageable pageable) {
        Page<Video> videoPage = videoRepository.findAll(videoCriteria.getSpecification(), pageable);
        ResponseListDto<List<VideoDto>> responseListDto = new ResponseListDto<>();
        responseListDto.setResults(videoMapper.fromEntityListToVideoDtoList(videoPage.getContent()));
        responseListDto.setPage(pageable.getPageNumber());
        responseListDto.setTotal_pages(videoPage.getTotalPages());
        responseListDto.setTotal_results(videoPage.getTotalElements());

        return responseListDto;
    }

    @Override
    public VideoDto createVideo(CreateVideoForm createVideoForm) {
        Video video = videoMapper.fromCreateVideoFormToEntity(createVideoForm);
        Movie movie = movieRepository.findById(createVideoForm.getMovieId()).orElse(null);
        if(movie != null){
            video.setMovie(movie);
        }
        videoRepository.save(video);
        return videoMapper.fromEntityToAdminDto(video);
    }

    @Override
    public VideoDto updateVideo(UpdateVideoForm updateVideoForm) {
        Video video = videoRepository.findById(updateVideoForm.getId())
                .orElseThrow(() -> new NotFoundException("Not found video"));
        videoMapper.fromUpdateVideoFormToEntity(updateVideoForm, video);
        videoRepository.save(video);
        return videoMapper.fromEntityToAdminDto(video);
    }

    @Override
    public void deleteVideo(long id) {
        Video video = videoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found video"));
        video.setStatus(0);
        videoRepository.save(video);
    }
}
