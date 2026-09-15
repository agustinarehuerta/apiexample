package com.tvmaze.apiexample.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@AllArgsConstructor
@Setter
@Getter
public class Links {

    Href self;
    @JsonProperty("previousepisode")
    PreviousEpisode previousEpisode;
}
