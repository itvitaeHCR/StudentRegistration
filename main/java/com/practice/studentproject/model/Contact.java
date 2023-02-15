package com.practice.studentproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String phone_nr;

    // RELATIONSHIP
    @OneToOne(mappedBy = "contact")
    @JsonIgnore
    private Student student;

    // CONSTRUCTOR
    public Contact() {}

    public Contact(String name, String phone_nr, Student student) {
        this.name = name;
        this.phone_nr = phone_nr;
        this.student = student;
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

    public String getPhone_nr() {
        return phone_nr;
    }

    public void setPhone_nr(String phone_nr) {
        this.phone_nr = phone_nr;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
