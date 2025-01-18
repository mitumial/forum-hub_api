package com.onechallenge.forumhubby.model;

import java.util.List;

public class Member {
    private Long id;
    private String alias;
    private String email;
    private String password;
    private List<Topic> topics;
    private List<Comment> comments;
}
