package com.example.backendsimplemovies.dto.cast;

import com.example.backendsimplemovies.dto.BasicAdminDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CastDto  extends BasicAdminDto{
    @ApiModelProperty(name = "castName", required = true)
    private String castName;

    @ApiModelProperty(name = "gender", required = true)
    private String gender;

    @ApiModelProperty(name = "profilePath", required = true)
    private String profilePath;
}
