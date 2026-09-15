package com.tvmaze.apiexample.mapper;

import java.util.List;

import com.tvmaze.apiexample.entity.CommentDocument;
import com.tvmaze.apiexample.model.CommentDto;
import com.tvmaze.apiexample.model.ShowCache;
import com.tvmaze.apiexample.model.ShowDetailDto;
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
                raw.resolveChannelName(),
                raw.getSummary(),
                raw.getGenres(),
                comments
        );
    }

    public static ShowCache toCache(TvMazeShowRaw raw) {
        return ShowCache.builder()
                .id(raw.getId())
                .url(raw.getUrl())
                .name(raw.getName())
                .type(raw.getType())
                .language(raw.getLanguage())
                .genres(raw.getGenres())
                .status(raw.getStatus())
                .runtime(raw.getRuntime())
                .averageRuntime(raw.getAverageRuntime())
                .premiered(raw.getPremiered())
                .ended(raw.getEnded())
                .officialSite(raw.getOfficialSite())
                .schedule(raw.getSchedule())
                .rating(raw.getRating())
                .network(raw.getNetwork())
                .webChannel(raw.getWebchannel_name())
                .image(raw.getImage())
                .summary(raw.getSummary())
                .build();
    }

        public static ShowDetailDto toDetailDto(TvMazeShowRaw raw, List<CommentDto> comments) {
        return ShowDetailDto.builder()
                .id(raw.getId())
                .name(raw.getName())
                .type(raw.getType())
                .language(raw.getLanguage())
                .genres(raw.getGenres())
                .status(raw.getStatus())
                .runtime(raw.getRuntime())
                .averageRuntime(raw.getAverageRuntime())
                .premiered(raw.getPremiered())
                .ended(raw.getEnded())
                .officialSite(raw.getOfficialSite())
                .schedule(raw.getSchedule())
                .rating(raw.getRating())
                .network(raw.getNetwork())
                .webchannel_name(raw.getWebchannel_name())
                .image(raw.getImage())
                .summary(raw.getSummary())
                .comments(comments)
                .build();
    }

    public static ShowDetailDto toDetailDto(ShowCache cache, List<CommentDto> comments) {
    return ShowDetailDto.builder()
            .id(cache.getId())
            .name(cache.getName())
            .type(cache.getType())
            .language(cache.getLanguage())
            .genres(cache.getGenres())
            .status(cache.getStatus())
            .runtime(cache.getRuntime())
            .averageRuntime(cache.getAverageRuntime())
            .premiered(cache.getPremiered())
            .ended(cache.getEnded())
            .officialSite(cache.getOfficialSite())
            .schedule(cache.getSchedule())
            .rating(cache.getRating())
            .network(cache.getNetwork())
            .webchannel_name(cache.getWebChannel())
            .image(cache.getImage())
            .summary(cache.getSummary())
            .comments(comments)
            .build();
    }
}