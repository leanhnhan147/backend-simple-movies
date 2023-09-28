package com.example.backendsimplemovies.form.movie;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class CreateMovieForm {
    @NotEmpty(message = "Title can not be null")
    @ApiModelProperty(name = "title", required = true)
    private String title;

    @NotEmpty(message = "Overview can not be null")
    @ApiModelProperty(name = "overview", required = true)
    private String overview;

    @NotEmpty(message = "Poster Path can not be null")
    @ApiModelProperty(name = "posterPath", required = true)
    private String poster_path;

    @NotEmpty(message = "Backdrop Path can not be null")
    @ApiModelProperty(name = "backdropPath", required = true)
    private String backdrop_path;

    @ApiModelProperty(name = "popularity")
    private Double popularity;

    @ApiModelProperty(name = "voteAverage")
    private Double vote_average;

    @ApiModelProperty(name = "voteCount")
    private Integer vote_count;

    @ApiModelProperty(name = "releaseDate")
    private Date release_date;
}
