package com.onechallenge.forumhubby.model;

import com.onechallenge.forumhubby.dto.DataCommentCreation;
import com.onechallenge.forumhubby.dto.DataCommentEditing;
import jakarta.persistence.*;
import jakarta.validation.Valid;
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

    public Comment(@Valid DataCommentCreation dataCommentCreation, Topic topic, Member commenter) {
        this.message = dataCommentCreation.message();
        this.isSolution = false;
        this.commenter = commenter;
        this.topic = topic;
    }


    public void updateComment(@Valid DataCommentEditing dataCommentEditing) {
        if (dataCommentEditing.message() != null) {
            this.message = dataCommentEditing.message();
        }
    }

    public void setAsSolution(){
        this.isSolution = true;
    }
}
