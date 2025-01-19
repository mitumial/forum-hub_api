package com.onechallenge.forumhubby.service;

import com.onechallenge.forumhubby.dto.DataCourseCreation;
import com.onechallenge.forumhubby.dto.DataCourseListing;
import com.onechallenge.forumhubby.model.Course;
import com.onechallenge.forumhubby.repository.CourseRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseRepository repository;

    public Course getReferenceById(Long id) {
        return repository.getReferenceById(id);
    }

    public Page<DataCourseListing> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(DataCourseListing::new);
    }

    public Course createCourse(@Valid DataCourseCreation dataCourseCreation) {
        Course course = new Course(dataCourseCreation);
        repository.save(course);
        return course;
    }

    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Course of ID " + id + " not found");
        }
        repository.deleteById(id);
    }
}
