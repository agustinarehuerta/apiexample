package com.tvmaze.apiexample.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TvMazeShowRaw {
    private Long id;
    private String name;
    private String webchannel_name;
    private String summary;
    private List<String> genres;
}

