package com.tvmaze.apiexample.controllers;

import com.tvmaze.apiexample.service.DbService;
import org.springframework.web.bind.annotation.RestController;

import com.tvmaze.apiexample.entity.Comment;
import com.tvmaze.apiexample.entity.Show;
import com.tvmaze.apiexample.model.TvMazeShow;
import com.tvmaze.apiexample.service.UserService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping("/api")
public class UserController {

    private final DbService dbService;
    private final UserService userService;

    
    public UserController(UserService userService, DbService dbService) {
        this.userService = userService;
        this.dbService = dbService;
    }


    @GetMapping("/getShows")
    public List<TvMazeShow> getShows(@RequestParam String search_query) {
        if (search_query == null || search_query.isBlank()) {
             throw new IllegalArgumentException(
                "Query parameter cannot be empty"
        );  
        }
        return userService.getShows(search_query);
    }

    @GetMapping("/getShowsById/{show_id}")
    public Show getShowsById(@PathVariable Long show_id) {
        if (show_id == null) {
             throw new IllegalArgumentException(
                "Query parameter cannot be empty"
        );  
        }
        return userService.getShowById(show_id);
    }

    @PostMapping("/saveComment")
    public ResponseEntity createComment(@RequestBody Comment comment) {
        
        userService.createComment(comment);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/saveShow")
    public Show createMovie(@RequestBody Show show) {
        return dbService.createMovie(show);
    }
    
    
}
