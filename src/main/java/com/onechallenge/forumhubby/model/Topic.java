package com.onechallenge.forumhubby.model;

import java.time.LocalDateTime;
import java.util.List;

public class Topic {
    private Long id;
    private String title;
    private String message;
    private Member originalPoster;
    private LocalDateTime datePosted;
    private String course;
    private List<Comment> comments;
    private String status;
}
