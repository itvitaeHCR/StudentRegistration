package com.practice.studentproject.controller;

import com.practice.studentproject.model.School;
import com.practice.studentproject.model.Student;
import com.practice.studentproject.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/school")
public class SchoolController {

    @Autowired
    SchoolService schoolService;

        // CRUD

    // CREATE
    @PostMapping("/new")
    public School newSchool(@RequestBody School school) {
        return schoolService.addSchool(school);
    }

    // READ
        //read one, by id
    @GetMapping("/{id}")
    public Optional<School> getSchoolById (@PathVariable(value = "id") Long id) {
        return schoolService.getSchoolById(id);
    }

        // read all
    @GetMapping("/all")
    public Iterable<School> getAllSchools() {
        return schoolService.getAllSchools();
    }

    // UPDATE
        // school by id
    @PutMapping("/{id}")
    public School updateSchoolById(@PathVariable(value = "id") Long id, @RequestBody School school) {
        return schoolService.updateSchoolById(id, school);
    }

        //add student to school
    @PutMapping("/{id}/newstudent")
    public School addStudentToSchool(@PathVariable(value = "id") long id, @RequestBody Student student) {
        return schoolService.addStudentToSchool(id, student);
    }

    // DELETE
        // delete by id
    @DeleteMapping("/delete/{id}")
    public void deleteSchoolById(@PathVariable(value = "id") long id) {
        schoolService.deleteSchoolById(id);
    }

        // delete all
    @DeleteMapping("/delete/all")
    public void deleteAllSchools() {
        schoolService.deleteAllSchools();
    }
}
