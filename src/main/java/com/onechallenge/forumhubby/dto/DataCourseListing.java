package com.onechallenge.forumhubby.dto;

import com.onechallenge.forumhubby.model.Course;

public record DataCourseListing(
        Long id,
        String name
) {
    public DataCourseListing(Course course) {
        this(course.getId(), course.getName());
    }
}
