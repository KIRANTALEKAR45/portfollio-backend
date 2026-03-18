package com.kiran.portfolio.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.kiran.portfolio.model.Contact;
import com.kiran.portfolio.repository.ContactRepository;
import com.kiran.portfolio.service.EmailService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactRepository repository;
    private final EmailService emailService;

    public ContactController(ContactRepository repository,
                             EmailService emailService) {
        this.repository = repository;
        this.emailService = emailService;
    }

    // ✅ Save Contact + Send Email Notification
    @PostMapping
    public Contact saveContact(@RequestBody Contact contact) {

        Contact savedContact = repository.save(contact);

        // send email notification
        emailService.sendNotification(
                contact.getName(),
                contact.getEmail(),
                contact.getMessage()
        );

        return savedContact;
    }

    // ✅ Get All Contacts
    @GetMapping
    public List<Contact> getAllContacts() {
        return repository.findAll();
    }

    // ✅ Delete Contact
    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
