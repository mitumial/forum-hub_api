package com.onechallenge.forumhubby.controller;

import com.onechallenge.forumhubby.dto.DataTopicClose;
import com.onechallenge.forumhubby.dto.DataTopicCreation;
import com.onechallenge.forumhubby.dto.DataTopicEditing;
import com.onechallenge.forumhubby.dto.DataTopicListing;
import com.onechallenge.forumhubby.model.Topic;
import com.onechallenge.forumhubby.service.CommentService;
import com.onechallenge.forumhubby.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/topics")
public class TopicController {
    @Autowired
    private TopicService service;

    @Autowired
    private CommentService commentService;

    @GetMapping
    public ResponseEntity<Page<DataTopicListing>> findAll(Pageable pageable){
        return ResponseEntity.ok(service.findByStatusActive(pageable).map(DataTopicListing::new));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataTopicListing> findById(@PathVariable Long id){
        Topic topic = service.getReferenceById(id);
        DataTopicListing dataTopicListing = new DataTopicListing(topic);
        return ResponseEntity.ok(dataTopicListing);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DataTopicCreation> createTopic(@RequestBody @Valid DataTopicCreation dataTopicCreation, UriComponentsBuilder uriComponentsBuilder){
        System.out.println("Received data: " + dataTopicCreation);
        Topic topic = service.createTopic(dataTopicCreation);
        URI url = uriComponentsBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(url).body(dataTopicCreation);
    }

    @PutMapping
    @Transactional
    public void editTopic(@RequestBody @Valid DataTopicEditing dataTopicEditing) {
        Topic topic = service.getReferenceById(dataTopicEditing.id());
        topic.updateTopic(dataTopicEditing);
    }

    @PutMapping("/close")
    @Transactional
    public void closeTopic(@RequestBody @Valid DataTopicClose dataTopicClose) {
        Topic topic = service.getReferenceById(dataTopicClose.topicId());
        commentService.getReferenceById(dataTopicClose.commentId()).setAsSolution();
        topic.closeTopic();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteTopic(@PathVariable Long id) {
        Topic topic = service.getReferenceById(id);
        topic.delete();
    }

}
