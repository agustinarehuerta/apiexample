package com.tvmaze.apiexample.service;

import org.springframework.stereotype.Service;

import com.tvmaze.apiexample.entity.Comment;
import com.tvmaze.apiexample.entity.Show;
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

    public Comment createComment(Comment comment){
           return commentRepository.save(comment);
    }
    
}
