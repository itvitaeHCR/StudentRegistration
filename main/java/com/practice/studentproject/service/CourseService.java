package com.practice.studentproject.service;

import com.practice.studentproject.model.Course;
import com.practice.studentproject.repository.CourseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    // for CREATE
    public Course newCourse(Course course) {
        return courseRepository.save(course);
    }

    // for READ
        // read one
    public Optional<Course> getCourseById(long id) {
        return courseRepository.findById(id);
    }

        // read all
    public Iterable<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    // for UPDATE
        // update course
    public Course updateCourseById(long id, Course course) {
        if (!courseRepository.existsById(id)) {
            return null;
        }
        Course prevCourse = courseRepository.findById(id).get();

        if (course.getName() != null) {
            prevCourse.setName(course.getName());
        }
        if (course.getCredits() != null) {
            prevCourse.setCredits(course.getCredits());
        }
        if (course.getStudents() != null) {
            prevCourse.setStudents(course.getStudents());
        }

        return courseRepository.save(prevCourse);
    }

    // for DELETE
        // delete one
    public void deleteCourseById(long id) {
        courseRepository.deleteById(id);
    }

        // delete all
    public void deleteAllCourses() {
        courseRepository.deleteAll();
    }
}
