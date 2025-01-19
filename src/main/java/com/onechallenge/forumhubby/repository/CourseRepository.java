package com.onechallenge.forumhubby.repository;

import com.onechallenge.forumhubby.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByName(String name);
}
