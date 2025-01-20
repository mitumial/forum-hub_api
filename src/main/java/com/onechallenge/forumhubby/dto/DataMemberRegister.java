package com.onechallenge.forumhubby.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record DataMemberRegister(
        @NotBlank
        String alias,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String password
) {
}
