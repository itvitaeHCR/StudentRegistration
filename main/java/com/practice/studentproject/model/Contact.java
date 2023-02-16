package com.practice.studentproject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    // CONSTRUCTORS - lombok generated

    // GETTERS AND SETTERS - lombok generated

}
