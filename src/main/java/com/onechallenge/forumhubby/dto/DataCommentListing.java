package com.onechallenge.forumhubby.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.onechallenge.forumhubby.model.Comment;

public record DataCommentListing(
        String message,
        @JsonProperty("date_posted")
        String datePosted,
        String commenter,
        @JsonProperty("is_solution")
        Boolean isSolution
) {
    public DataCommentListing (Comment comment){
        this(comment.getMessage(), comment.getDatePosted().toString(), comment.getCommenter().getAlias(), comment.getIsSolution());
    }
}
