package com.klu.clubconnect.controller;

import com.klu.clubconnect.dto.LoginRequest;
import com.klu.clubconnect.dto.LoginResponse;
import com.klu.clubconnect.dto.RegisterRequest;
import com.klu.clubconnect.model.User;
import com.klu.clubconnect.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {
    
    @Autowired
    private UserService userService;
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            LoginResponse response = userService.login(request);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody RegisterRequest request) {
        try {
            User user = userService.register(request);
            return ResponseEntity.ok(user);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}