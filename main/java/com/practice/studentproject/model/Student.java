package com.practice.studentproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer grade;

    // RELATIONSHIPS
    // Courses - many to many - owning side
    @ManyToMany
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses = new ArrayList<>();

    // Contact - one to one
    @OneToOne
    @JoinColumn(name = "contact_id")
    private Contact contact;


    // School - many-to-one
    @ManyToOne
    @JsonBackReference
    private School school;


    // CONSTRUCTORS - lombok generated

    // GETTERS AND SETTERS - lombok generated

}
