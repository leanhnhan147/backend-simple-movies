package com.example.backendsimplemovies.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseListDto<T> {
    private Integer page;
    private T results;
    private Integer total_pages;
    private Long total_results;

}
