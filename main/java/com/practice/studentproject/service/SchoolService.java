package com.practice.studentproject.service;

import com.practice.studentproject.model.School;
import com.practice.studentproject.model.Student;
import com.practice.studentproject.repository.SchoolRepository;
import com.practice.studentproject.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class SchoolService {

    @Autowired
    SchoolRepository schoolRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    StudentService studentService;

    // for CREATE
    public School addSchool(School school) {
        return schoolRepository.save(school);
    }


    // for READ
        //get one, by id
    public Optional<School> getSchoolById(Long id) {
        return schoolRepository.findById(id);
    }

        //get all
    public Iterable<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    // for UPDATE
        // update school by id
    public School updateSchoolById(Long id, School school) {
        if (!schoolRepository.existsById(id)) {
            return null;
        }
        School prevSchool = schoolRepository.findById(id).get();
        //update name
        if (school.getName() != null) {
            prevSchool.setName((school.getName()));
        }
        //update city
        if (school.getCity() != null) {
            prevSchool.setCity(school.getCity());
        }

        return schoolRepository.save(prevSchool);
    }

        // add student to school
    public School addStudentToSchool(long id, Student student) {
        if (!schoolRepository.existsById(id)) {
            return null;
        }

        School school = schoolRepository.findById(id).get();
        Student tempStudent = studentService.addStudentToSchool(school, student);

        school.getStudents().add(tempStudent);
        Integer size = school.getStudents().size();
        school.setNr_of_students(size);
        return schoolRepository.save(school);
    }


    // for DELETE
        // delete one
    public void deleteSchoolById(long id) {
        schoolRepository.deleteById(id);
    }

    public void deleteAllSchools() {
        schoolRepository.deleteAll();
    }

    // delete all


}
