package com.tvmaze.apiexample.client;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClient;

import com.tvmaze.apiexample.entity.Show;
import com.tvmaze.apiexample.model.TvMazeSearchItem;
import com.tvmaze.apiexample.model.TvMazeShowRaw;

@Component 
public class TvMazeClient {

    private final RestClient restClient;

    public TvMazeClient(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("https://api.tvmaze.com")
                .build();
    }

    public List<TvMazeSearchItem> getShows(String query) {

               TvMazeSearchItem[] result = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/search/shows")
                        .queryParam("q", query)
                        .build())
                .retrieve()
                .body(TvMazeSearchItem[].class);

        return result != null ? Arrays.asList(result) : Collections.emptyList();
    }

    public TvMazeShowRaw getShowById(Long id) {
        try {
            return restClient.get()
                    .uri("/shows/{id}", id)
                    .retrieve()
                    .body(TvMazeShowRaw.class);
        } catch (HttpClientErrorException.NotFound notFound) {
            return null;
        }
    }

        public Show getById2(Long id) {
        try {
            return restClient.get()
                    .uri("/shows/{id}", id)
                    .retrieve()
                    .body(Show.class);
        } catch (HttpClientErrorException.NotFound notFound) {
            return null;
        }
    }
}
