package com.example.backendsimplemovies.mapper;

import com.example.backendsimplemovies.dto.genre.GenreDto;
import com.example.backendsimplemovies.dto.video.VideoDto;
import com.example.backendsimplemovies.entity.Genre;
import com.example.backendsimplemovies.entity.Video;
import com.example.backendsimplemovies.form.genre.CreateGenreForm;
import com.example.backendsimplemovies.form.genre.UpdateGenreForm;
import com.example.backendsimplemovies.form.video.CreateVideoForm;
import com.example.backendsimplemovies.form.video.UpdateVideoForm;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE, uses = MovieMapper.class)
public interface VideoMapper {

    @Mapping(source = "videoName", target = "name")
    @Mapping(source = "videoPath", target = "path")
    @Mapping(source = "publishedDate", target = "publishedDate")
    @BeanMapping(ignoreByDefault = true)
    @Named("adminCreateMapping")
    Video fromCreateVideoFormToEntity(CreateVideoForm createVideoForm);

    @Mapping(source = "videoName", target = "name")
    @Mapping(source = "videoPath", target = "path")
    @Mapping(source = "publishedDate", target = "publishedDate")
    @Mapping(source = "status", target = "status")
    @BeanMapping(ignoreByDefault = true)
    @Named("adminUpdateMapping")
    void fromUpdateVideoFormToEntity(UpdateVideoForm updateVideoForm, @MappingTarget Video video);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "videoName")
    @Mapping(source = "path", target = "videoPath")
    @Mapping(source = "publishedDate", target = "publishedDate")
    @Mapping(source = "movie", target = "movie", qualifiedByName = "adminGetMapping")
    @Mapping(source = "createdDate", target = "createdDate")
    @Mapping(source = "modifiedDate", target = "modifiedDate")
    @Mapping(source = "status", target = "status")
    @BeanMapping(ignoreByDefault = true)
    @Named("adminGetMapping")
    VideoDto fromEntityToAdminDto(Video video);

    @IterableMapping(elementTargetType = VideoDto.class, qualifiedByName = "adminGetMapping")
    List<VideoDto> fromEntityListToVideoDtoList(List<Video> videos);
}
