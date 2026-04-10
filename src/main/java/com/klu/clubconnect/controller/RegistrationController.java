package com.klu.clubconnect.controller;

import com.klu.clubconnect.model.Registration;
import com.klu.clubconnect.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/registrations")
@CrossOrigin(origins = "http://localhost:3000")
public class RegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @PostMapping("/register")
    public String register(@RequestParam Long userId, @RequestParam Long eventId) {
        try {
            return registrationService.registerForEvent(userId, eventId);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @DeleteMapping("/unregister")
    public String unregister(@RequestParam Long userId, @RequestParam Long eventId) {
        try {
            return registrationService.unregisterFromEvent(userId, eventId);
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

    @GetMapping("/user/{userId}")
    public List<Registration> getUserRegistrations(@PathVariable Long userId) {
        return registrationService.getUserRegistrations(userId);
    }
}