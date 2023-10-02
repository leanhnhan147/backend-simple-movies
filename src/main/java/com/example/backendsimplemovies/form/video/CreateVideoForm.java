package com.example.backendsimplemovies.form.video;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class CreateVideoForm {
    @NotEmpty(message = "Video name can not be null")
    @ApiModelProperty(name = "videoName", required = true)
    private String videoName;

    @NotEmpty(message = "Video Path can not be null")
    @ApiModelProperty(name = "videoPath", required = true)
    private String videoPath;

    @ApiModelProperty(name = "publishedDate")
    private Date publishedDate;

    @NotNull(message = "Movie id can not be null")
    @ApiModelProperty(name = "movieId", required = true)
    private Long movieId;
}
