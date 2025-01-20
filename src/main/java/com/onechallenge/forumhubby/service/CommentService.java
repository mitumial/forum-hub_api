package com.onechallenge.forumhubby.service;

import com.onechallenge.forumhubby.dto.DataCommentCreation;
import com.onechallenge.forumhubby.dto.DataCommentListing;
import com.onechallenge.forumhubby.model.Comment;
import com.onechallenge.forumhubby.model.Member;
import com.onechallenge.forumhubby.model.Topic;
import com.onechallenge.forumhubby.repository.CommentRepository;
import com.onechallenge.forumhubby.repository.MemberRepository;
import com.onechallenge.forumhubby.repository.TopicRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private TopicRepository topicRepository;
    @Autowired
    private MemberRepository memberRepository;

    public Comment getReferenceById(Long id) {
        return commentRepository.getReferenceById(id);
    }

    public Page<DataCommentListing> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable).map(DataCommentListing::new);
    }

    public Comment createComment(@Valid DataCommentCreation dataCommentCreation) {
        Topic topic = topicRepository.findById(dataCommentCreation.topicId()).orElse(null);
        Member commenter = memberRepository.findById(dataCommentCreation.commenterId()).orElse(null);
        Comment comment = new Comment(dataCommentCreation,topic, commenter);
        return commentRepository.save(comment);
    }

    public void deleteById(Long id) {
        if (!commentRepository.existsById(id)) {
            throw new EntityNotFoundException("Comment of ID " + id + " not found");
        }
        commentRepository.deleteById(id);
    }

    public Page<Comment> findByTopic(Topic topic, Pageable pageable) {
        return commentRepository.findByTopic(topic, pageable);
    }
}
