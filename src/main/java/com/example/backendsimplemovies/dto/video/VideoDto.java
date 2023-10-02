package com.example.backendsimplemovies.dto.video;

import com.example.backendsimplemovies.dto.BasicAdminDto;
import com.example.backendsimplemovies.dto.Movie.MovieDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VideoDto extends BasicAdminDto {
    @NotEmpty(message = "Video name can not be null")
    @ApiModelProperty(name = "videoName", required = true)
    private String videoName;

    @NotEmpty(message = "Video Path can not be null")
    @ApiModelProperty(name = "videoPath", required = true)
    private String videoPath;

    @ApiModelProperty(name = "publishedDate")
    private Date publishedDate;

    @ApiModelProperty(name = "movie")
    private MovieDto movie;
}
