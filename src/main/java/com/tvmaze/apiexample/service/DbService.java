package com.tvmaze.apiexample.service;

import org.springframework.stereotype.Service;

import com.tvmaze.apiexample.entity.Show;
import com.tvmaze.apiexample.repository.ShowRepositry;

@Service 
public class DbService {

    private final ShowRepositry showRepositry;

    public DbService(ShowRepositry showRepositry) {
        this.showRepositry = showRepositry;
    }

    public Show getShowById(String id){

        return showRepositry.findById(id).orElse(null);

    }
    
    public Show createMovie(Show show) {
        return showRepositry.save(show);
    }
    
}
