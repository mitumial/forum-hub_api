package com.onechallenge.forumhubby.service;

import com.onechallenge.forumhubby.dto.DataTopicCreation;
import com.onechallenge.forumhubby.model.Course;
import com.onechallenge.forumhubby.model.Member;
import com.onechallenge.forumhubby.model.PostStatus;
import com.onechallenge.forumhubby.model.Topic;
import com.onechallenge.forumhubby.repository.CourseRepository;
import com.onechallenge.forumhubby.repository.MemberRepository;
import com.onechallenge.forumhubby.repository.TopicRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private MemberRepository memberRepository;

    public Topic createTopic(@Valid DataTopicCreation dataTopicCreation){
        Course course = courseRepository.findByName(dataTopicCreation.courseName());
        Member originalPoster = memberRepository.findById(dataTopicCreation.originalPosterId()).orElse(null);
        return new Topic(dataTopicCreation, course, originalPoster);
    }

    public Page<Topic> findByStatusActive(Pageable pageable) {
        return topicRepository.findByStatus(PostStatus.ACTIVE, pageable);
    }

    public Topic getReferenceById(Long id) {
        return topicRepository.getReferenceById(id);
    }
}
