package com.tvmaze.apiexample.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.tvmaze.apiexample.model.TvMazeShow;
import com.tvmaze.apiexample.service.UserService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController 
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/getShows")
    public List<TvMazeShow> getMethodName(@RequestParam String search_query) {
        if (search_query == null || search_query.isBlank()) {
             throw new IllegalArgumentException(
                "Query parameter cannot be empty"
        );  
        }
        return userService.getShows(search_query);
    }
    
}
