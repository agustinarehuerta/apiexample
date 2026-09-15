package com.tvmaze.apiexample.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@AllArgsConstructor
@Setter
@Getter
public class Externals {
    Long tvrage;
    Long thetvdb;
    String imdb;
}
