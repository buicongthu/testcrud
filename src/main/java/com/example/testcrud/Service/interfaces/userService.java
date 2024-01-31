package com.example.testcrud.Service.interfaces;

import com.example.testcrud.Dto.userDto;
import org.springframework.http.ResponseEntity;

public interface userService {
    public void adduser(userDto dto);

}
