package com.tvmaze.apiexample.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "shows_cache")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowCache {

    @Id
    private Long id;

    private String url;
    private String name;
    private String type;
    private String language;
    private List<String> genres;
    private String status;
    private Integer runtime;
    private Integer averageRuntime;
    private String premiered;
    private String ended;
    private String officialSite;
    private ScheduleDto schedule;
    private RatingDto rating;
    private ChannelInfo network;
    private ChannelInfo webChannel;
    private ImageDto image;
    private String summary;
}

