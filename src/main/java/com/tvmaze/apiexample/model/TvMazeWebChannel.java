package com.tvmaze.apiexample.model;

/**
 * TvMazeWebChannel
 */
public record TvMazeWebChannel(
        Long id,
        String name,
        TvMazeCountry country,
        String officialSite
) {
}
