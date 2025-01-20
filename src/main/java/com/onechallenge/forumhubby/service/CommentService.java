package com.onechallenge.forumhubby.service;

import com.onechallenge.forumhubby.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository repository;
}
