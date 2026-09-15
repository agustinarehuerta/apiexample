package com.tvmaze.apiexample.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.tvmaze.apiexample.entity.CommentDocument;

public interface CommentRepository extends MongoRepository<CommentDocument, String> {

    List<CommentDocument> findByShowId(Long showId);
    List<CommentDocument> findByShowIdIn(List<Long> showIds);

}
