package com.example.backendsimplemovies.form.cast;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class UpdateCastForm {
    @NotNull(message = "Id can not be null")
    @ApiModelProperty(name = "id", required = true)
    private Long id;

    @NotEmpty(message = "Cast name can not be null")
    @ApiModelProperty(name = "castName", required = true)
    private String castName;

    @NotEmpty(message = "Gender can not be null")
    @ApiModelProperty(name = "gender", required = true)
    private String gender;

    @NotEmpty(message = "Profile Path can not be null")
    @ApiModelProperty(name = "profilePath", required = true)
    private String profilePath;

    @ApiModelProperty(name = "status")
    private Integer status;
}
