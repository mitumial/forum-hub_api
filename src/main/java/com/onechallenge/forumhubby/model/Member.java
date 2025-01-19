package com.onechallenge.forumhubby.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Member")
@Table(name = "members")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String alias;
    private String email;
    private String password;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
    private List<Topic> topics;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "commenter")
    private List<Comment> comments;
}
