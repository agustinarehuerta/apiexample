package com.tvmaze.apiexample.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * TvMazeLinks
 */
public record TvMazeLinks(
        TvMazeSelf self,
        @JsonProperty("previousepisode")
        TvMazePreviousEpisode previousEpisode
) {
}
