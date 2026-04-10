package com.klu.clubconnect.controller;

import com.klu.clubconnect.model.User;
import com.klu.clubconnect.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/api/otp")
@CrossOrigin(origins = "http://localhost:3000")
public class OtpController {

    @Autowired
    private UserRepository userRepository;
    
    // Store OTP temporarily (phone -> otp)
    private Map<String, String> otpStore = new HashMap<>();

    @PostMapping("/send")
    public String sendOtp(@RequestParam String phone) {
        String otp = String.format("%06d", new Random().nextInt(999999));
        otpStore.put(phone, otp);
        System.out.println("OTP for " + phone + " is: " + otp);
        return "OTP sent to " + phone + " - Your OTP: " + otp;
    }

    @PostMapping("/verify")
    public String verifyOtp(@RequestParam String phone, @RequestParam String otp) {
        String storedOtp = otpStore.get(phone);
        if (storedOtp != null && storedOtp.equals(otp)) {
            otpStore.remove(phone);
            return "OTP verified successfully";
        }
        return "Invalid OTP";
    }
}