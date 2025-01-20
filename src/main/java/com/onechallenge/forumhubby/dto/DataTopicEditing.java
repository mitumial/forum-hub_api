package com.onechallenge.forumhubby.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataTopicEditing(
        @NotNull
        Long id,
        @NotBlank
        String message
) {
}
