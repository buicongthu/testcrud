package com.example.testcrud.Controller;

import com.example.testcrud.Dto.request.loginRequest;
import com.example.testcrud.Dto.userDto;
import com.example.testcrud.Entity.JwtResponse;
import com.example.testcrud.Security.JwtTokenProvider;
import com.example.testcrud.Service.interfaces.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
public class authController {
    @Autowired
    private userService userService;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody userDto userDto) {
        try {
            userService.adduser(userDto);
            return ResponseEntity.ok("add successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public String login(@RequestBody loginRequest loginRequest) {
        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(
//                            loginRequest.getUsername(),
////                            passwordEncoder.encode(loginRequest.getPassword())
//                            loginRequest.getPassword()
//                    )
//            );
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());
            Authentication authenticationRequest =
                    authenticationManager.authenticate(usernamePasswordAuthenticationToken);
            SecurityContextHolder.getContext().setAuthentication(authenticationRequest);
            System.out.println(SecurityContextHolder.getContext().getAuthentication());
            String token = jwtTokenProvider.createToken(loginRequest.getUsername());
//        String token = jwtTokenProvider.createToken(loginRequest.getUsername());

            System.out.println("Login đc rồi");
            return token;
        } catch(Exception e){
            e.printStackTrace();
            return "Login failed!";
        }
    }
    @PostMapping("/test")
    public String test(@RequestBody loginRequest loginRequest){
        return loginRequest.getUsername();
    }
}