package com.tvmaze.apiexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TvMazeShowResponse{
    private Long id;
    private String name;
    private String channel;
    private String summary;
    private List<String> genres;
    private List<CommentDto> comments;
}