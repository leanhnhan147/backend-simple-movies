package com.example.backendsimplemovies.form.genre;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UpdateGenreForm {
    @NotNull(message = "Id can not be null")
    @ApiModelProperty(name = "id", required = true)
    private Long id;

    @NotEmpty(message = "Genre name can not be null")
    @ApiModelProperty(name = "genreName", required = true)
    private String genreName;

    @ApiModelProperty(name = "status")
    private Integer status;
}
