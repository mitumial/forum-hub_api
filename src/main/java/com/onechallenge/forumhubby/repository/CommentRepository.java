package com.onechallenge.forumhubby.repository;

import com.onechallenge.forumhubby.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
