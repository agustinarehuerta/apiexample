package com.tvmaze.apiexample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TvMazeSearchItem {
    private Double score;
    private TvMazeShowRaw show;
}