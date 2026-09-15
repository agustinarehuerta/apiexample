package com.tvmaze.apiexample.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.tvmaze.apiexample.client.TvMazeClient;
import com.tvmaze.apiexample.entity.CommentDocument;

import com.tvmaze.apiexample.exception.ShowNotFoundException;
import com.tvmaze.apiexample.mapper.ShowMapper;
import com.tvmaze.apiexample.model.CommentDto;
import com.tvmaze.apiexample.model.CommentRequestDto;
import com.tvmaze.apiexample.model.ShowCache;
import com.tvmaze.apiexample.model.ShowDetailDto;
import com.tvmaze.apiexample.model.TvMazeSearchItem;
import com.tvmaze.apiexample.model.TvMazeShowRaw;
import com.tvmaze.apiexample.model.TvMazeShowResponse;
import com.tvmaze.apiexample.repository.CommentRepository;
import com.tvmaze.apiexample.repository.ShowCacheRepository;

@Service 
public class UserService {

    private final TvMazeClient tvMazeClient;
    private final DbService dbService;
    private final CommentRepository commentRepository;
    private final ShowCacheRepository showCacheRepository;

     public UserService(DbService dbService,TvMazeClient tvMazeClient,CommentRepository commentRepository,ShowCacheRepository showCacheRepository) {
        this.dbService = dbService;
        this.tvMazeClient = tvMazeClient;
        this.commentRepository = commentRepository;
        this.showCacheRepository = showCacheRepository;
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

    public ShowDetailDto getShowById(Long show_id) {

        List<CommentDto> comments = commentRepository.findByShowId(show_id).stream()
        .map(ShowMapper::toCommentDto)
        .collect(Collectors.toList());

        Optional<ShowCache> cached = showCacheRepository.findById(show_id);
        if (cached.isPresent()) {
            return ShowMapper.toDetailDto(cached.get(), comments);
        }

        TvMazeShowRaw raw = tvMazeClient.getShowById(show_id);
        if (raw == null) {
            throw new ShowNotFoundException("Show con id " + show_id + " no fue encontrado en TVMaze");
        }

        showCacheRepository.save(ShowMapper.toCache(raw));
        return ShowMapper.toDetailDto(raw, comments);
    }

    public void createComment(Long showId, CommentRequestDto request){

        dbService.createComment(showId,request);
    }
}
