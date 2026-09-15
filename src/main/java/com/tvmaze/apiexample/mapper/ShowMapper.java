package com.tvmaze.apiexample.mapper;

import java.util.List;

import com.tvmaze.apiexample.entity.CommentDocument;
import com.tvmaze.apiexample.model.CommentDto;
import com.tvmaze.apiexample.model.TvMazeShowRaw;
import com.tvmaze.apiexample.model.TvMazeShowResponse;

public final class ShowMapper {

    private ShowMapper() {
    }

    public static CommentDto toCommentDto(CommentDocument doc) {
        return new CommentDto(doc.getComment(), doc.getRating());
    }

       public static TvMazeShowResponse toSummaryDto(TvMazeShowRaw raw, List<CommentDto> comments) {
        return new TvMazeShowResponse(
                raw.getId(),
                raw.getName(),
                raw.getWebchannel_name(),
                raw.getSummary(),
                raw.getGenres(),
                comments
        );
    }
}