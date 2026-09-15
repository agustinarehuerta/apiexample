package com.tvmaze.apiexample.service;

import org.springframework.stereotype.Service;

import com.tvmaze.apiexample.entity.CommentDocument;
import com.tvmaze.apiexample.model.CommentRequestDto;
import com.tvmaze.apiexample.repository.CommentRepository;

@Service 
public class DbService {

    private final CommentRepository commentRepository;

    public DbService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    public void createComment(Long showId, CommentRequestDto request){
                
        CommentDocument document = CommentDocument.builder()
        .showId(showId)
        .comment(request.getComment())
        .rating(request.getRating())
        .build();
        commentRepository.save(document);
    }

    public CommentDocument getComment(String id){
        return commentRepository.findById(id).orElse(null);
    }
    
}
