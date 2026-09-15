package com.tvmaze.apiexample.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@NoArgsConstructor
@Data
@Document(collection = "show")
public class Show{

        @Id
        String id;
        String url;
        String name;
        String type;
        String language;
        List<String> genres;
        String status;
        Integer runtime;
        Integer averageRuntime;
        String premiered;
        String ended;
        String officialSite;
        Schedule schedule;
        Rating rating;
        Integer weight;
        Network network;
        String webChannel;
        String dvdCountry;
        Externals externals;
        Image image;
        String summary;
        Long updated;
        @JsonProperty("_links")
        Links links;
}