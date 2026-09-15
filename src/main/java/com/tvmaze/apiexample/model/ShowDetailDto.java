package com.tvmaze.apiexample.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowDetailDto {
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
    private String summary;
    private Long updated;
    private String weight;
    @JsonProperty("_links")
    private LinksDto links;
    private List<CommentDto> comments;
}
