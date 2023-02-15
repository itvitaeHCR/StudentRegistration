package com.practice.studentproject.service;

import com.practice.studentproject.model.Course;
import com.practice.studentproject.model.School;
import com.practice.studentproject.model.Student;
import com.practice.studentproject.repository.CourseRepository;
import com.practice.studentproject.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    //for CREATE
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    //for READ
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(long id) {
        return studentRepository.findById(id);
    }

    //for UPDATE
    public Student updateStudentById(long id, Student student) {
        if (!studentRepository.existsById(id)) { // guard class
            return null;
        }
        Student prevStudent = studentRepository.findById(id).get();
        if (student.getName() != null) {
            prevStudent.setName(student.getName());
        }
        if (student.getGrade() != null) {
            prevStudent.setGrade(student.getGrade());
        }
        if (student.getSchool() != null) {
            prevStudent.setSchool(student.getSchool());
        }
        System.out.println("update successful");

        return student;
    }

    //for DELETE
    public String deleteStudentById(long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return "student removed from database";
        }
        return "error while trying to remove student from database";
    }

    public void deleteAllStudents() {
        studentRepository.deleteAll();
    }


    // UPDATE from OTHER
    public Student addStudentToSchool(School school, Student student) {
        student.setSchool(school);
        return studentRepository.save(student);
    }


//    public Student addCourseToStudent(long id, Course course) {
//        if (!studentRepository.existsById(id)) {
//            return null;
//        }
//
//        Student student = studentRepository.findById(id).get();
//        Course tempCourse = courseRepository.addCourseToStudent(course, student);
//
//        student.getCourses().add(tempCourse);
//
//        return studentRepository.save(student);
//    }

}
