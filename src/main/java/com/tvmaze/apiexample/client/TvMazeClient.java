package com.tvmaze.apiexample.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.http.HttpStatusCode;

import com.tvmaze.apiexample.exception.TvMazeException;
import com.tvmaze.apiexample.model.TvMazeByIDResponse;
import com.tvmaze.apiexample.model.TvMazeSearchResponse;

@Component 
public class TvMazeClient {

    private final RestClient restClient;

    public TvMazeClient(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder
                .baseUrl("https://api.tvmaze.com")
                .build();
    }

    @SuppressWarnings("null")
    public List<TvMazeSearchResponse> getShows(String query) {

    try {

            TvMazeSearchResponse[] response = restClient
                    .get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/search/shows")
                            .queryParam("q", query)
                            .build())
                    .retrieve()
                    .onStatus(
                            HttpStatusCode::isError,
                            (request, response1) -> {
                                throw new TvMazeException(
                                        "TVMaze API returned status: "
                                                + response1.getStatusCode()
                                );
                            }
                    )
                    .body(TvMazeSearchResponse[].class);

            return response != null
                    ? Arrays.asList(response)
                    : List.of();

        } catch (TvMazeException e) {
            throw e;

        } catch (Exception e) {
            throw new TvMazeException(
                    "Error de comunicacion con TVMaze API",
                    e
            );
        }
    }

    public List<TvMazeByIDResponse> getById(Long id) {

    try {

           TvMazeByIDResponse response = restClient
            .get()
            .uri("/shows/{id}", id)
            .retrieve()
            .onStatus(
                    status -> status.value() == 404,
                    (request, responseone) -> {
                        throw new TvMazeException(
                                "Show with id " + id + " was not found"
                        );
                    }
            )
            .body(TvMazeByIDResponse.class);


            return response != null
                    ? Arrays.asList(response)
                    : List.of();

        } catch (TvMazeException e) {
            throw e;

        } catch (Exception e) {
            throw new TvMazeException(
                    "Error de comunicacion con TVMaze API",
                    e
            );
        }
    }

}
