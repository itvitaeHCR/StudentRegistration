package com.practice.studentproject.repository;

import com.practice.studentproject.model.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ContactRepository extends CrudRepository<Contact, Long> {}
