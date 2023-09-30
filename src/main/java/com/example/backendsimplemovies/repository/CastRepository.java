package com.example.backendsimplemovies.repository;

import com.example.backendsimplemovies.entity.Cast;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CastRepository extends JpaRepository<Cast, Long>, JpaSpecificationExecutor<Cast> {
}
