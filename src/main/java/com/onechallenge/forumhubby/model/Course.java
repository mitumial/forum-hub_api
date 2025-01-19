package com.onechallenge.forumhubby.model;

import com.onechallenge.forumhubby.dto.DataCourseCreation;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Course")
@Table(name = "courses")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
    private List<Topic> topics;

    public Course(DataCourseCreation dataCourseCreation) {
        this.name = dataCourseCreation.name();
    }
}
