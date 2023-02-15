package com.practice.studentproject.controller;


import com.practice.studentproject.model.Course;
import com.practice.studentproject.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    CourseService courseService;

        // CRUD

    // CREATE
    @PostMapping("/new")
    public Course newCourse(@RequestBody Course course) {
        return courseService.newCourse(course);
    }

    // READ
    @GetMapping("/read/{id}")
    public Optional<Course> getCourseById(@PathVariable(value = "id") long id) {
        return courseService.getCourseById(id);
    }

    @GetMapping("/read/all")
    public Iterable<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    // UPDATE
        // update course
    @PutMapping("update/{id}")
    public Course updateCourse(@PathVariable(value = "id") long id, @RequestBody Course course) {
        return courseService.updateCourseById(id, course);
    }

        // adding students > courses added to students in StudentController


    // DELETE
        //delete one
    @DeleteMapping("/delete/{id}")
    public void deleteCourseById(@PathVariable(value = "id") long id) {
        courseService.deleteCourseById(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteAllCourses() {
        courseService.deleteAllCourses();
    }

}
