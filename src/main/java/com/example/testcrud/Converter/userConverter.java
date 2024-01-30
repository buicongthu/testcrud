package com.example.testcrud.Converter;

import com.example.testcrud.Dto.userDto;
import com.example.testcrud.Entity.user;
import org.springframework.stereotype.Component;

@Component
public class userConverter {
    public user toEntity(userDto dto){
        user user = new user();
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        return user;
    }
    public user toDto(user dto){
        user user = new user();
        user.setName(dto.getName());
        user.setPassword(dto.getPassword());
        return dto;
    }
}
