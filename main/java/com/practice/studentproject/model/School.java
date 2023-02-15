package com.practice.studentproject.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
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


    // CONSTRUCTORS

    public School() {
    }

    public School(String name, String city, List<Student> students, Integer nr_of_students) {
        this.name = name;
        this.city = city;
        this.students = students;
        this.nr_of_students = nr_of_students;
    }


    // GETTERS AND SETTERS

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNr_of_students() {
        return nr_of_students;
    }

    public void setNr_of_students(Integer nr_of_students) {
        this.nr_of_students = nr_of_students;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}