package com.tvmaze.apiexample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tvmaze.apiexample.model.ShowCache;

public interface ShowCacheRepository extends MongoRepository<ShowCache, Long> {
}

