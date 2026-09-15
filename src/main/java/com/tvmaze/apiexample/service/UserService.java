package com.tvmaze.apiexample.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tvmaze.apiexample.client.TvMazeClient;
import com.tvmaze.apiexample.entity.CommentDocument;
import com.tvmaze.apiexample.entity.Show;
import com.tvmaze.apiexample.mapper.ShowMapper;
import com.tvmaze.apiexample.model.CommentDto;
import com.tvmaze.apiexample.model.CommentRequestDto;
import com.tvmaze.apiexample.model.TvMazeSearchItem;
import com.tvmaze.apiexample.model.TvMazeShowRaw;
import com.tvmaze.apiexample.model.TvMazeShowResponse;
import com.tvmaze.apiexample.repository.CommentRepository;

@Service 
public class UserService {

    private final TvMazeClient tvMazeClient;
    private final DbService dbService;
    private final CommentRepository commentRepository;

     public UserService(DbService dbService,TvMazeClient tvMazeClient,CommentRepository commentRepository) {
        this.dbService = dbService;
        this.tvMazeClient = tvMazeClient;
        this.commentRepository = commentRepository;
    }

    public List<TvMazeShowResponse> getShows(String query) {

        List<TvMazeSearchItem> items = tvMazeClient.getShows(query);

        List<Long> showIds = items.stream()
        .map(item -> item.getShow().getId())
        .collect(Collectors.toList());

        Map<Long, List<CommentDto>> commentsByShowId = commentRepository.findByShowIdIn(showIds)
                .stream()
                .collect(Collectors.groupingBy(
                        CommentDocument::getShowId,
                        Collectors.mapping(ShowMapper::toCommentDto, Collectors.toList())
                ));

         return items.stream()
                .map(item -> {TvMazeShowRaw raw = item.getShow();

                    List<CommentDto> comments = commentsByShowId.getOrDefault(raw.getId(), Collections.emptyList());
                    return ShowMapper.toSummaryDto(raw, comments);
                })
                .collect(Collectors.toList());
    }

    public Show getShowById(Long show_id) {

        Show response = dbService.getShowById(show_id.toString());
        if (response == null) {
           response = tvMazeClient.getById2(show_id.longValue());
           dbService.createMovie(response);
        }

        return response;
    }

    public void createComment(Long showId, CommentRequestDto request){

        dbService.createComment(showId,request);
    }
}
