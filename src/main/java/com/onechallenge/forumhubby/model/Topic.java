package com.onechallenge.forumhubby.model;

import com.onechallenge.forumhubby.dto.DataTopicCreation;
import com.onechallenge.forumhubby.dto.DataTopicEditing;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "original_poster_id")
    private Member originalPoster;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic", cascade = CascadeType.ALL)
    private List<Comment> comments;

    @ManyToOne(fetch = FetchType.LAZY)
    private Course course;

    public Topic(DataTopicCreation dataTopicCreation,Course course, Member originalPoster) {
        this.title = dataTopicCreation.title();
        this.message = dataTopicCreation.message();
        this.status = PostStatus.ACTIVE;
        this.originalPoster = originalPoster;
        this.comments = new ArrayList<>();
        this.course = course;
    }

    public void updateTopic(@Valid DataTopicEditing dataTopicEditing) {
        if (dataTopicEditing.message() != null) {
            this.message = dataTopicEditing.message();
        }
    }

    public void closeTopic(){
        this.status = PostStatus.SOLVED;
    }

    public void delete() {
        this.status = PostStatus.DELETED;
    }
}
