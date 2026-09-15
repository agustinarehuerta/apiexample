package com.tvmaze.apiexample.model;

import java.util.List;

/**
 * TvMazeSchedule
 */
public record TvMazeSchedule(
        String time,
        List<String> days
) {
}
