package com.example.testcrud.Controller;

import com.example.testcrud.Dto.request.loginRequest;
import com.example.testcrud.Dto.userDto;
import com.example.testcrud.Service.interfaces.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
public class authController {
    @Autowired
    private userService userService;
    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody userDto userDto){
        try{
            userService.adduser(userDto);
            return ResponseEntity.ok("add successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
//    @PostMapping("/login")
//    public ResponseEntity<Object> login(@RequestBody loginRequest loginRequest){
//
//    }
}
