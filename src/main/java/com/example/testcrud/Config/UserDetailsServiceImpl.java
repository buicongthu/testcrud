package com.example.testcrud.Config;

import com.example.testcrud.Entity.user;
import com.example.testcrud.Repository.userRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private userRepo userRepo;
    @Override
    public UserDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
        user user = userRepo.findByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("nguoi dung khong ton tai ");
        }
        return new UserDetailsImpl(user);
    }
}
