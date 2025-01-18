package com.onechallenge.forumhubby.model;

import java.time.LocalDateTime;

public class Comment {
    private Long id;
    private String message;
    private Member commenter;
    private LocalDateTime datePosted;
    private Topic topic;
}
