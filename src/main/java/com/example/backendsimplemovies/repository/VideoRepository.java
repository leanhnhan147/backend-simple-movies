package com.example.backendsimplemovies.repository;

import com.example.backendsimplemovies.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VideoRepository extends JpaRepository<Video, Long>, JpaSpecificationExecutor<Video> {
    @Query("SELECT v FROM Video v WHERE v.movie.id = :movieId")
    List<Video>findVideoByMovieId(@Param("movieId") Long movieId);
}
