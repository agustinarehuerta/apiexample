package com.tvmaze.apiexample.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class TvMazeShowRaw {
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
    private NetworkDto network;
    private ChannelInfo webChannel;
    private ExternalsDto externals;
    private ImageDto image;
    private Long updated;
    private String weight;
    @JsonProperty("_links")
    private LinksDto links;
    private String summary;


    public String resolveChannelName() {
    if (network != null && network.getName() != null) {
        return network.getName();
    }
    if (webChannel != null && webChannel.getName() != null) {
        return webChannel.getName();
    }
    return null;
}
}

