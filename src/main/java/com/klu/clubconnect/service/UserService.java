package com.klu.clubconnect.service;

import com.klu.clubconnect.dto.LoginRequest;
import com.klu.clubconnect.dto.LoginResponse;
import com.klu.clubconnect.dto.RegisterRequest;
import com.klu.clubconnect.model.User;
import com.klu.clubconnect.repository.UserRepository;
import com.klu.clubconnect.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private JwtUtil jwtUtil;
    
    public LoginResponse login(LoginRequest request) {
        System.out.println("Login attempt for email: " + request.getEmail());
        
        Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
        
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        
        User user = userOpt.get();
        
        System.out.println("User found - Name: " + user.getName() + ", Role: " + user.getRole());
        
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        
        String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
        
        System.out.println("Login success - Returning role: " + user.getRole());
        
        return new LoginResponse(
            token, "Bearer", user.getId(), user.getName(),
            user.getEmail(), user.getRole(), user.getAvatar(), user.getTotalPoints()
        );
    }
    
    public User register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }
        
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhone(request.getPhone());
        user.setDob(request.getDob());
        
        if (request.getAdminId() != null && !request.getAdminId().isEmpty()) {
            user.setRole("ADMIN");
            user.setStatus("ACTIVE");
            user.setCollege("Admin");
            user.setYear("Staff");
            user.setDepartment("Administration");
            user.setAvatar("👑");
            System.out.println("Creating ADMIN user: " + request.getEmail());
        } else {
            user.setRole("STUDENT");
            user.setCollege(request.getCollege());
            user.setYear(request.getYear());
            user.setDepartment(request.getDepartment());
            user.setAvatar("👨‍🎓");
            System.out.println("Creating STUDENT user: " + request.getEmail());
        }
        
        return userRepository.save(user);
    }
    
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}