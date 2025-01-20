package com.onechallenge.forumhubby.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataTopicCreation(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotNull
        @JsonAlias("original_poster_id")Long originalPosterId,
        @NotNull
        @JsonAlias("courseId")Long courseId
) {
}
