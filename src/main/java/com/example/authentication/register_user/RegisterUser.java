package com.example.authentication.register_user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.authentication.mail_sender.EmailServiceImpl;

@RestController
public class RegisterUser {
    
    @Autowired
    EmailServiceImpl emailServiceImpl;

    @GetMapping("/otp/{email}")
    public String generateOpt(@PathVariable("email")String emailId){
        return emailServiceImpl.sendOtp(emailId);
    }

    @GetMapping("/ok")
    public String ok(){
        return "ok";
    }
}
