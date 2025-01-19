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
    private LocalDateTime datePosted;
    private Boolean isSolution;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "commenter_id")
    private Member commenter;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "topic_id")
    private Topic topic;
}
