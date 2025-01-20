package com.onechallenge.forumhubby.repository;

import com.onechallenge.forumhubby.model.Comment;
import com.onechallenge.forumhubby.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Page<Comment> findByTopic(Topic topic, Pageable pageable);
}
