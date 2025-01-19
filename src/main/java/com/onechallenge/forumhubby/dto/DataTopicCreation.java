package com.onechallenge.forumhubby.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataTopicCreation(
        @NotBlank
        String title,
        @NotBlank
        String message,
        @NotNull
        Long originalPosterId,
        @NotBlank
        String courseName
) {
}
