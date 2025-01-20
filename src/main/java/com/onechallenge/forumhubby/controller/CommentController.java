package com.onechallenge.forumhubby.controller;

import com.onechallenge.forumhubby.dto.DataCommentCreation;
import com.onechallenge.forumhubby.dto.DataCommentEditing;
import com.onechallenge.forumhubby.dto.DataCommentListing;
import com.onechallenge.forumhubby.model.Comment;
import com.onechallenge.forumhubby.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService service;

//    @GetMapping
//    public ResponseEntity<Page<DataCommentListing>> findAll(Pageable pageable){
//        return ResponseEntity.ok(service.findByStatusActive(pageable).map(DataCommentListing::new));
//    }

    @GetMapping("/{id}")
    public ResponseEntity<DataCommentListing> findById(@PathVariable Long id){
        Comment comment = service.getReferenceById(id);
        DataCommentListing dataCommentListing = new DataCommentListing(comment);
        return ResponseEntity.ok(dataCommentListing);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DataCommentCreation> createComment(@RequestBody @Valid DataCommentCreation dataCommentCreation, UriComponentsBuilder uriComponentsBuilder){
        System.out.println("Received data: " + dataCommentCreation);
        Comment comment = service.createComment(dataCommentCreation);
        URI url = uriComponentsBuilder.path("/comments/{id}").buildAndExpand(comment.getId()).toUri();
        return ResponseEntity.created(url).body(dataCommentCreation);
    }

    @PutMapping
    @Transactional
    public void editComment(@RequestBody @Valid DataCommentEditing dataCommentEditing) {
        Comment comment = service.getReferenceById(dataCommentEditing.id());
        comment.updateComment(dataCommentEditing);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
