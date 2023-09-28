package com.example.backendsimplemovies.dto.Movie;

import com.example.backendsimplemovies.dto.BasicAdminDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

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
}
