package com.example.backendsimplemovies.dto.genre;

import com.example.backendsimplemovies.dto.BasicAdminDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDto extends BasicAdminDto {
    @ApiModelProperty(name = "genreName", required = true)
    private String genreName;
}
