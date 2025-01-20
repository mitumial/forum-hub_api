package com.onechallenge.forumhubby.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DataCommentCreation(
        @NotBlank
        String message,
        @NotNull
        @JsonProperty("commenter_id")
        Long commenterId,
        @NotNull
        @JsonProperty("topic_id")
        Long topicId
) {
}
