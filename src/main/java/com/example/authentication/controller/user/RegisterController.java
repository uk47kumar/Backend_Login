package com.example.authentication.controller;

import com.example.authentication.exception.DuplicateException;
import com.example.authentication.model.user.User;
import com.example.authentication.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.authentication.service.mail.EmailServiceImpl;

import java.util.Date;

@RestController
public class RegisterController {

    @Autowired
    private EmailServiceImpl emailServiceImpl;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@ModelAttribute User user) {
        try {
            user.setVerified(false);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setOtp(userService.sendOtp(user.getEmail()));
            userService.save(user);
            return ResponseEntity.status(HttpStatus.CREATED).body("Register Successfully");
        }catch (Exception e){
            throw new DuplicateException("Duplicate email: Try to login with different email !!");
        }
    }

    @PostMapping("/verify")
    public ResponseEntity<String> verifyUser(@RequestParam("email") String email,
                                             @RequestParam("otp") String otp) {
        User user = userService.findByEmail(email);
        if (user == null) {
            return ResponseEntity.ok("You Don't Have Account");
        }
        if (user.isVerified()) {
            return ResponseEntity.ok("You are already verified");
        }
        if (user.getOtp().equals(otp)) {
            user.setEmail_verified_at(new Date());
            user.setVerified(true);
            user.setOtp("0");
            userService.save(user);
        } else {
            return ResponseEntity.ok("Invalid Otp");
        }
        return ResponseEntity.ok("Otp Verified");
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<User> findById(@PathVariable("id") Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }
}
