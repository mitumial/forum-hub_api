package com.onechallenge.forumhubby.controller;

import com.onechallenge.forumhubby.dto.DataTopicCreation;
import com.onechallenge.forumhubby.model.Topic;
import com.onechallenge.forumhubby.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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



    @PostMapping
    @Transactional
    public ResponseEntity<DataTopicCreation> createTopic(@RequestBody @Valid DataTopicCreation dataTopicCreation, UriComponentsBuilder uriComponentsBuilder){
        Topic topic = service.createTopic(dataTopicCreation);
        URI url = uriComponentsBuilder.path("/topics/{id}").buildAndExpand(topic.getId()).toUri();
        return ResponseEntity.created(url).body(dataTopicCreation);
    }
}
