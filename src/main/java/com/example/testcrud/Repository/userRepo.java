package com.example.testcrud.Repository;

import com.example.testcrud.Entity.user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepo extends JpaRepository<user,Integer> {
    user findByName(String username);
}
