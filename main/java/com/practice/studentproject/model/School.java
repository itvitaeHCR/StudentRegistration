package com.practice.studentproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    private String city;

    // RELATIONSHIP one-to-many
    @OneToMany
    @JsonManagedReference
    private List<Student> students = new ArrayList<>();
    private Integer nr_of_students = students.size();


    // CONSTRUCTORS - lombok generated

    // GETTERS AND SETTERS - lombok generated
}