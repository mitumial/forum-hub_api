package com.onechallenge.forumhubby.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity(name = "Comment")
@Table(name = "comments")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String message;
    private LocalDateTime datePosted;
    private Boolean solution;

    @ManyToOne(fetch = FetchType.EAGER)
    private Member commenter;

    @ManyToOne(fetch = FetchType.EAGER)
    private Topic topic;
}
