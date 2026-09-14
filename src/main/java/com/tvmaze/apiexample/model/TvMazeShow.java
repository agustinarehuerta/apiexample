package com.tvmaze.apiexample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TvMazeShow(
        Long id,
        String name,
        String webchannel_name,
        String summary,
        List<String> genres
) {
}