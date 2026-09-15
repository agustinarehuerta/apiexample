package com.tvmaze.apiexample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tvmaze.apiexample.entity.Show;

public interface ShowRepository
        extends MongoRepository<Show, String> {

}   
