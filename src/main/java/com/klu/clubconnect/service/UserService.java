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
        Optional<User> userOpt = userRepository.findByEmail(request.getEmail());
        
        if (userOpt.isEmpty()) {
            throw new RuntimeException("User not found");
        }
        
        User user = userOpt.get();
        
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        
        String token = jwtUtil.generateToken(user.getEmail(), user.getRole());
        
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
        user.setCollege(request.getCollege());
        user.setYear(request.getYear());
        user.setDepartment(request.getDepartment());
        
        // ✅ ADMIN or STUDENT based on adminId
        if (request.getAdminId() != null && !request.getAdminId().isEmpty()) {
            user.setRole("ADMIN");
            user.setAvatar("👑");
            user.setStatus("ACTIVE");
        } else {
            user.setRole("STUDENT");
            user.setAvatar("👨‍🎓");
            user.setStatus("ACTIVE");
        }
        
        user.setTotalPoints(0);
        
        return userRepository.save(user);
    }
    
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}