package com.onechallenge.forumhubby.dto;

import org.springframework.data.domain.Page;

public record DataTopicWithComments(
        DataTopicListing topic,
        Page<DataCommentListing> comments
) {

    public DataTopicWithComments(DataTopicListing topic, Page<DataCommentListing> comments) {
        this.topic = topic;
        this.comments = comments;
    }
}
