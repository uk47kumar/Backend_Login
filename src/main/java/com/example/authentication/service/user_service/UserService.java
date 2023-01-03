package com.example.authentication.service.user_service;

import com.example.authentication.exception.ResourceNotFoundException;
import com.example.authentication.model.User;
import com.example.authentication.repo.UserRepo;
import com.example.authentication.service.mail_sender.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private EmailServiceImpl emailService;

    public User save(User user){

        return userRepo.save(user);
    }

    public String sendOtp(String email){
        return emailService.sendOtp(email);
    }

    public User findByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public User findById(Long id){
        return userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("user with given id is not found"));
    }

}
