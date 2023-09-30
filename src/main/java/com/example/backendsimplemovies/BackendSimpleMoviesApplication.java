package com.example.backendsimplemovies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BackendSimpleMoviesApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendSimpleMoviesApplication.class, args);
    }

}
