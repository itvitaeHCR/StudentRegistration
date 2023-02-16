package com.practice.studentproject.controller;

import com.practice.studentproject.model.Contact;
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

        // add contact to student
    @PutMapping("/contact/{student_id}/{contact_id}")
    public Student addContactToStudent(@PathVariable(value = "student_id") long student_id, @PathVariable(value = "contact_id") long contact_id) {
        return studentService.addContactToStudent(student_id, contact_id);
    }

         //add course to student                                                                        !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    @PutMapping("/course/{student_id}/{course_id}")
    public Student addCourseToStudent(@PathVariable(value = "student_id") long student_id, @PathVariable(value = "course_id") long course_id) {
        return studentService.addCourseToStudent(student_id, course_id);
    }


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
