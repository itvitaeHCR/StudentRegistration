package com.practice.studentproject.controller;

import com.practice.studentproject.model.Contact;
import com.practice.studentproject.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/api/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

        // CRUD

    // CREATE
    @PostMapping("/new")
    public Contact newContact(@RequestBody Contact contact) {
        return contactService.newContact(contact);
    }

    // READ
        //read one
    @GetMapping("/read/{id}")
    public Optional<Contact> getContactById(@PathVariable(value = "id") long id) {
        return contactService.getContactById(id);
    }

        //read all
    @GetMapping("/read/all")
    public Iterable<Contact> getAllContacts() {
        return contactService.getAllContacts();
    }

    // Update
    @PutMapping("update/{id}")
    public Contact updateContactById(@PathVariable(value = "id") long id, @RequestBody Contact contact) {
        return contactService.updateContactById(id, contact);
    }


    // Delete
        //delete one
    @DeleteMapping("/delete/{id}")
    public void deleteContactById(@PathVariable(value = "id") long id) {
        contactService.deleteContactById(id);
    }

        //delete all
    @DeleteMapping("/delete/all")
    public void deleteAllContacts() {
        contactService.deleteAllContacts();
    }

}
