package com.onechallenge.forumhubby.dto;

import jakarta.validation.constraints.NotBlank;

public record DataCourseCreation(
        @NotBlank
        String name
) {
}
