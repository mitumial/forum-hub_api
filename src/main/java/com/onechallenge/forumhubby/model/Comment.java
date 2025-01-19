package com.onechallenge.forumhubby.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

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

    @CreationTimestamp
    @Column(name = "date_posted")
    private LocalDateTime datePosted;

    @Column(name = "is_solution")
    private Boolean isSolution;

    @ManyToOne(fetch = FetchType.LAZY)
    private Member commenter;

    @ManyToOne(fetch = FetchType.LAZY)
    private Topic topic;
}
