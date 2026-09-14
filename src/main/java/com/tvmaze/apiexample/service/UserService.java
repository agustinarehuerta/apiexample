package com.tvmaze.apiexample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tvmaze.apiexample.client.TvMazeClient;
import com.tvmaze.apiexample.model.TvMazeSearchResponse;
import com.tvmaze.apiexample.model.TvMazeShow;

@Service 
public class UserService {

    private final TvMazeClient tvMazeClient;

    public UserService(TvMazeClient tvMazeClient) {
        this.tvMazeClient = tvMazeClient;
    }

     @SuppressWarnings("null")
    public List<TvMazeShow> getShows(String query) {
        return tvMazeClient.getShows(query)
        .stream()
        .map(TvMazeSearchResponse::show)
        .toList();
    }

}
