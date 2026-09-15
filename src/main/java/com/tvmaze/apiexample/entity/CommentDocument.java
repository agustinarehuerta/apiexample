package com.tvmaze.apiexample.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "show")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDocument {

    @Id
    private String id;

    @Indexed
    private Long showId;

    private String comment;
    private Integer rating;
}
