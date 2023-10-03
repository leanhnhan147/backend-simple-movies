package com.example.backendsimplemovies.dto.Movie;

import com.example.backendsimplemovies.dto.BasicAdminDto;
import com.example.backendsimplemovies.entity.Cast;
import com.example.backendsimplemovies.entity.Genre;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto extends BasicAdminDto {
    @ApiModelProperty(name = "title")
    private String title;

    @NotEmpty(message = "Overview can not be null")
    @ApiModelProperty(name = "overview")
    private String overview;

    @NotEmpty(message = "Poster Path can not be null")
    @ApiModelProperty(name = "posterPath")
    private String poster_path;

    @NotEmpty(message = "Backdrop Path can not be null")
    @ApiModelProperty(name = "backdropPath")
    private String backdrop_path;

    @ApiModelProperty(name = "popularity")
    private Double popularity;

    @ApiModelProperty(name = "voteAverage")
    private Double vote_average;

    @ApiModelProperty(name = "voteCount")
    private Integer vote_count;

    @ApiModelProperty(name = "releaseDate")
    private Date release_date;

    @ApiModelProperty(name = "genres")
    private List<Genre> genres;

    @ApiModelProperty(name = "casts")
    private List<Cast> casts;
}
