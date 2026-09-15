package com.tvmaze.apiexample.service;

import org.springframework.stereotype.Service;

import com.tvmaze.apiexample.entity.CommentDocument;
import com.tvmaze.apiexample.entity.Show;
import com.tvmaze.apiexample.model.CommentRequestDto;
import com.tvmaze.apiexample.repository.CommentRepository;
import com.tvmaze.apiexample.repository.ShowRepository;

@Service 
public class DbService {

    private final ShowRepository showRepository;
    private final CommentRepository commentRepository;

    public DbService(ShowRepository showRepositry, CommentRepository commentRepository) {
        this.showRepository = showRepositry;
        this.commentRepository = commentRepository;
    }

    public Show getShowById(String id){

        return showRepository.findById(id).orElse(null);

    }
    
    public Show createMovie(Show show) {
        return showRepository.save(show);
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
