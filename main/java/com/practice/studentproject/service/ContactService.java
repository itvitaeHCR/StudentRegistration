package com.practice.studentproject.service;

import com.practice.studentproject.model.Contact;
import com.practice.studentproject.model.Student;
import com.practice.studentproject.repository.ContactRepository;
import com.practice.studentproject.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class ContactService {

    @Autowired
    ContactRepository contactRepository;


    // for CREATE
    public Contact newContact(Contact contact) {
        return contactRepository.save(contact);
    }

    // for READ

    public Optional<Contact> getContactById(long id) {
        return contactRepository.findById(id);
    }

    public Iterable<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    // for UPDATE
    public Contact updateContactById(long id, Contact contact) {
        if (!contactRepository.existsById(id)) {
            return null;
        }

        Contact prevContact = contactRepository.findById(id).get();

        if (contact.getName() != null) {
            prevContact.setName(contact.getName());
        }
        if (contact.getPhone_nr() != null) {
            prevContact.setPhone_nr(contact.getPhone_nr());
        }
        if (contact.getStudent() != null) {
            prevContact.setStudent(contact.getStudent());
        }
        return contactRepository.save(prevContact);
    }

    // add contact to student
    public Contact addContacttoStudent(Contact contact, Student student) {
        contact.setStudent(student);
        return contactRepository.save(contact);
    }



    // for DELETE
    public void deleteContactById(long id) {
        contactRepository.deleteById(id);
    }

    public void deleteAllContacts() {
        contactRepository.deleteAll();
    }
}
