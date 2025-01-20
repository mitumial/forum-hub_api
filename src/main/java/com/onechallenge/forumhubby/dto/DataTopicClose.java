package com.onechallenge.forumhubby.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;

public record DataTopicClose(
        @NotNull
        @JsonProperty("topic_id")
        Long topicId,
        @NotNull
        @JsonProperty("comment_id")
        Long commentId
) {
}
