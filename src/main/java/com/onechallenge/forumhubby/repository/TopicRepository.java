package com.onechallenge.forumhubby.repository;

import com.onechallenge.forumhubby.model.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Long> {
}
