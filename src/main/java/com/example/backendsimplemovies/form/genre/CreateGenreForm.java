package com.example.backendsimplemovies.form.genre;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class CreateGenreForm {
    @NotEmpty(message = "Genre name can not be null")
    @ApiModelProperty(name = "genreName", required = true)
    private String genreName;
}
