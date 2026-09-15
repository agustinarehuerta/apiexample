package com.tvmaze.apiexample.model;

/**
 * TvMazeNetwork
 */
public record TvMazeNetwork(
        Long id,
        String name,
        TvMazeCountry country,
        String officialSite
) {
}