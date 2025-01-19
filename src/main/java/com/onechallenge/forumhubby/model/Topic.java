package com.onechallenge.forumhubby.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Topic")
@Table(name = "topics")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String message;

    @CreationTimestamp
    @Column(name = "date_posted")
    private LocalDateTime datePosted;
    @Enumerated(EnumType.STRING)
    private PostStatus status;

    @Column(name = "original_poster")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "original_poster_id")
    private Member originalPoster;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;
}
