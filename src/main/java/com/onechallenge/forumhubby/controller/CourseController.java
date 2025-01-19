package com.onechallenge.forumhubby.controller;

import com.onechallenge.forumhubby.dto.DataCourseCreation;
import com.onechallenge.forumhubby.dto.DataCourseListing;
import com.onechallenge.forumhubby.model.Course;
import com.onechallenge.forumhubby.service.CourseService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService service;

    @GetMapping
    public ResponseEntity<Page<DataCourseListing>> findAll(@PageableDefault(size = 10, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataCourseListing> findById(@PathVariable Long id) {
        Course course = service.getReferenceById(id);
        DataCourseListing dataCourseListing = new DataCourseListing(course);
        return ResponseEntity.ok(dataCourseListing);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<DataCourseCreation> createCourse(@RequestBody @Valid DataCourseCreation dataCourseCreation, UriComponentsBuilder uriComponentsBuilder) {
        Course course = service.createCourse(dataCourseCreation);
        URI url = uriComponentsBuilder.path("/courses/{id}").buildAndExpand(course.getId()).toUri();
        return ResponseEntity.created(url).body(dataCourseCreation);
    }
}