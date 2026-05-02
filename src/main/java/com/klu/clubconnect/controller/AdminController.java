package com.klu.clubconnect.controller;

import com.klu.clubconnect.model.Registration;
import com.klu.clubconnect.model.User;
import com.klu.clubconnect.repository.RegistrationRepository;
import com.klu.clubconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RegistrationRepository registrationRepository;

    @GetMapping("/students")
    public List<User> getAllStudents() {
        return userRepository.findAll();
    }

    @GetMapping("/registrations")
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    @PutMapping("/students/{id}/status")
    public User toggleStatus(@PathVariable Long id) {
        User user = userRepository.findById(id).get();
        if ("ACTIVE".equals(user.getStatus())) {
            user.setStatus("BLOCKED");
        } else {
            user.setStatus("ACTIVE");
        }
        return userRepository.save(user);
    }
}