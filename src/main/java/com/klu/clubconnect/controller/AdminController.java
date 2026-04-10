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

    // Get all students
    @GetMapping("/students")
    public List<User> getAllStudents() {
        List<User> allUsers = userRepository.findAll();
        return allUsers.stream()
                .filter(user -> "STUDENT".equals(user.getRole()))
                .toList();
    }

    // Get student by ID
    @GetMapping("/students/{id}")
    public User getStudentById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    // Toggle student status (Block/Unblock)
    @PutMapping("/students/{id}/status")
    public User toggleStudentStatus(@PathVariable Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        
        if ("ACTIVE".equals(user.getStatus())) {
            user.setStatus("BLOCKED");
        } else {
            user.setStatus("ACTIVE");
        }
        
        return userRepository.save(user);
    }

    // Get all registrations
    @GetMapping("/registrations")
    public List<Registration> getAllRegistrations() {
        return registrationRepository.findAll();
    }

    // Get statistics
    @GetMapping("/stats")
    public StatsResponse getStats() {
        long totalStudents = userRepository.findAll().stream()
                .filter(user -> "STUDENT".equals(user.getRole()))
                .count();
        
        return new StatsResponse(totalStudents);
    }

    // Stats Response class
    static class StatsResponse {
        private final long totalStudents;
        
        public StatsResponse(long totalStudents) {
            this.totalStudents = totalStudents;
        }
        
        public long getTotalStudents() {
            return totalStudents;
        }
    }
}