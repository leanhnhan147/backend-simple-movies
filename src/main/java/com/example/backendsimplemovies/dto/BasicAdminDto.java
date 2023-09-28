package com.example.backendsimplemovies.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BasicAdminDto {
    @ApiModelProperty(name = "id")
    private Long id;

    @ApiModelProperty(name = "createdDate")
    private LocalDateTime createdDate;

    @ApiModelProperty(name = "modifiedDate")
    private LocalDateTime modifiedDate;

    @ApiModelProperty(name = "status")
    private Integer status;
}
