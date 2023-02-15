package com.practice.studentproject.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
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


    // CONSTRUCTORS
    public Student() {
    }

    public Student(String name, Integer grade, List<Course> courses, Contact contact, School school) {
        this.name = name;
        this.grade = grade;
        this.courses = courses;
        this.contact = contact;
        this.school = school;
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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
