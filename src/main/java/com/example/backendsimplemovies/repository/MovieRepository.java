package com.example.backendsimplemovies.repository;

import com.example.backendsimplemovies.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long>, JpaSpecificationExecutor<Movie> {
    List<Movie> findByOrderByPopularityDesc();

    List<Movie> findByOrderByVoteAverageDesc();

}
