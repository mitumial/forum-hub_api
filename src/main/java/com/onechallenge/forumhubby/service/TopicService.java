package com.onechallenge.forumhubby.service;

import com.onechallenge.forumhubby.dto.DataTopicCreation;
import com.onechallenge.forumhubby.infra.error.DuplicateException;
import com.onechallenge.forumhubby.model.Course;
import com.onechallenge.forumhubby.model.Member;
import com.onechallenge.forumhubby.model.PostStatus;
import com.onechallenge.forumhubby.model.Topic;
import com.onechallenge.forumhubby.repository.CourseRepository;
import com.onechallenge.forumhubby.repository.MemberRepository;
import com.onechallenge.forumhubby.repository.TopicRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private MemberRepository memberRepository;

    public Topic createTopic(@Valid DataTopicCreation dataTopicCreation){
        if (topicRepository.existsByTitleAndMessage(dataTopicCreation.title(), dataTopicCreation.message())){
            throw new DuplicateException("A topic of equal title and message has already been posted.");
        }

        Course course = courseRepository.findById(dataTopicCreation.courseId()).orElseThrow(EntityNotFoundException::new);;
        Member originalPoster = memberRepository.findById(dataTopicCreation.originalPosterId()).orElseThrow(EntityNotFoundException::new);;
        Topic topic = new Topic(dataTopicCreation, course, originalPoster);
        topicRepository.save(topic);
        return topic;
    }

    public Page<Topic> findByStatusActive(Pageable pageable) {
        return topicRepository.findByStatus(PostStatus.ACTIVE, pageable);
    }

    public Topic findById(Long id) {
        return topicRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}
