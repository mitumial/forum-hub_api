package com.onechallenge.forumhubby.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.onechallenge.forumhubby.model.Topic;

public record DataTopicListing(
        String title,
        String message,
        @JsonProperty("date_posted")
        String datePosted,
        String status,
        @JsonProperty("original_poster")
        String originalPoster,
        String course
) {
    public DataTopicListing (Topic topic){
        this(topic.getTitle(),
                topic.getMessage(),
                topic.getDatePosted().toString(),
                topic.getStatus().toString(),
                topic.getOriginalPoster().getAlias(),
                topic.getCourse().getName()
        );
    }
}

 //(título, mensaje, fecha de creación, estado, autor y curso)