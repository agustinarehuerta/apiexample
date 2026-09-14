package com.tvmaze.apiexample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TvMazeSearchResponse(
        Double score,
        TvMazeShow show
)
{}
