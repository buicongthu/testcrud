package com.example.testcrud.Controller;

import com.example.testcrud.Dto.request.loginRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/test")
public class testController {
    @PostMapping("/test")
    public String test(@RequestBody loginRequest loginRequest){
        return loginRequest.getUsername();
    }
}
