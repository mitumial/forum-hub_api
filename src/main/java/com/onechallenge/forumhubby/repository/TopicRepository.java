package com.onechallenge.forumhubby.repository;

import com.onechallenge.forumhubby.model.PostStatus;
import com.onechallenge.forumhubby.model.Topic;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {
    Page<Topic> findByStatus(PostStatus status, Pageable pageable);

    Boolean existsByTitleAndMessage(String title, String message);
}
