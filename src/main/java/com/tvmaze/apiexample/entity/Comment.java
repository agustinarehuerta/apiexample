package com.tvmaze.apiexample.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@NoArgsConstructor
@Data
@Document(collection = "show")
public class Comment {
        @Id
        String id;
        String comment;
        Integer rating;
}
