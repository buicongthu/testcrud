package com.example.testcrud.Service.impl;

import com.example.testcrud.Dto.userDto;
import com.example.testcrud.Entity.user;
import com.example.testcrud.Repository.userRepo;
import com.example.testcrud.Service.interfaces.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.testcrud.Converter.userConverter;

@Service
public class userServiceimpl implements userService {
    @Autowired
    private userRepo userRepo;
    @Autowired
    private userConverter userConverter;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void adduser(userDto dto) {
        user user = userConverter.toEntity(dto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
    }
}
