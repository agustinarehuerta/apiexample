package com.tvmaze.apiexample.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * TvMazeRating
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public record TvMazeRating(
        Double average
) {
}
