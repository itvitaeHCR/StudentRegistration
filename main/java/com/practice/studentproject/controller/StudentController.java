package com.practice.studentproject.controller;

import com.practice.studentproject.model.Course;
import com.practice.studentproject.model.School;
import com.practice.studentproject.model.Student;
import com.practice.studentproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/student")
public class StudentController {
    @Autowired
    StudentService studentService;

        // CRUD

    //CREATE
    @PostMapping("/new")
    public Student newStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    //READ
    @GetMapping("/all")
    public Iterable<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable(value = "id") long id) {
        return studentService.getStudentById(id);
    }

    //UPDATE
        // edit student
    @PutMapping("/{id}")
    public Student updateStudentById(@PathVariable(value = "id") long id, @RequestBody Student student) {
        return studentService.updateStudentById(id, student);
    }

        // add course to student                                                                        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//    @PutMapping("/{id}/newcourse")
//    public Student addCourseToStudent(@PathVariable(value = "id") long id, @RequestBody Course course) {
//        return studentService.addCourseToStudent(id, course);
//    }


    //DELETE
    @DeleteMapping("/{id}")
    public String deleteStudentById(@PathVariable(value = "id") long id) {
        return studentService.deleteStudentById(id);
    }

    @DeleteMapping("/all/")
    public void deleteAllStudents() {
        studentService.deleteAllStudents();
    }

}
