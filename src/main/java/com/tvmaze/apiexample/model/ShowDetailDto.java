package com.tvmaze.apiexample.model;

import java.util.List;

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
    private ChannelInfo webchannel_name;
    private ImageDto image;
    private String summary;
    private List<CommentDto> comments;
}
