package com.onechallenge.forumhubby.dto;

import com.onechallenge.forumhubby.model.Topic;

public record DataTopicListing(
        String title,
        String message,
        String datePosted,
        String status,
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