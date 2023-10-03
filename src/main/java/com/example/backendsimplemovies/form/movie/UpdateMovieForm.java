package com.example.backendsimplemovies.form.movie;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class UpdateMovieForm {
    @NotNull(message = "Id can not be null")
    @ApiModelProperty(name = "id", required = true)
    private Long id;

    @NotEmpty(message = "Title can not be null")
    @ApiModelProperty(name = "title", required = true)
    private String title;

    @NotEmpty(message = "Overview can not be null")
    @ApiModelProperty(name = "overview", required = true)
    private String overview;

    @NotEmpty(message = "Poster path can not be null")
    @ApiModelProperty(name = "posterPath", required = true)
    private String poster_path;

    @NotEmpty(message = "Backdrop Path can not be null")
    @ApiModelProperty(name = "backdropPath", required = true)
    private String backdrop_path;

    @ApiModelProperty(name = "releaseDate")
    private Date release_date;

    @ApiModelProperty(name = "status")
    private Integer status;

    @NotNull(message = "genres cant not be null")
    @ApiModelProperty(name = "genres", required = true)
    private Long[] genres;

    @NotNull(message = "casts cant not be null")
    @ApiModelProperty(name = "casts", required = true)
    private Long[] casts;
}
