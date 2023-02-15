package com.practice.studentproject.repository;

import com.practice.studentproject.model.School;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface SchoolRepository extends CrudRepository<School, Long> {}
