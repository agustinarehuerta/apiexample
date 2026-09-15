package com.tvmaze.apiexample.model;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CommentRequestDto {

    @NotBlank(message = "El comentario no puede estar vacío")
    private String comment;

    @NotNull(message = "El rating es obligatorio")
    @Min(value = 0, message = "El rating mínimo es 0")
    @Max(value = 5, message = "El rating máximo es 5")
    private Integer rating;
}
