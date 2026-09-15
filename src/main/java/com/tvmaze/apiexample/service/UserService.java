package com.tvmaze.apiexample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tvmaze.apiexample.client.TvMazeClient;
import com.tvmaze.apiexample.entity.Show;
import com.tvmaze.apiexample.model.TvMazeSearchResponse;
import com.tvmaze.apiexample.model.TvMazeShow;

@Service 
public class UserService {

    private final TvMazeClient tvMazeClient;
    private final DbService dbService;

     public UserService(DbService dbService,TvMazeClient tvMazeClient) {
        this.dbService = dbService;
        this.tvMazeClient = tvMazeClient;
    }

     @SuppressWarnings("null")
    public List<TvMazeShow> getShows(String query) {
        return tvMazeClient.getShows(query)
        .stream()
        .map(TvMazeSearchResponse::show)
        .toList();
    }

    public Show getShowById(Long show_id) {

        Show response = dbService.getShowById(show_id.toString());
        if (response == null) {
           response = tvMazeClient.getById(show_id.longValue());
           dbService.createMovie(response);
        }

        return response;
    }

}
