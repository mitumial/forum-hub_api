package com.onechallenge.forumhubby.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataTopicCreation(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotNull
        @JsonProperty("original_poster_id")
        Long originalPosterId,
        @NotNull
        @JsonProperty("course_id")
        Long courseId
) {
}
