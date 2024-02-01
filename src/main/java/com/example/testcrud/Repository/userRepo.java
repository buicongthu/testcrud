package com.example.testcrud.Repository;

import com.example.testcrud.Entity.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface userRepo extends JpaRepository<user,Integer> {
    user findByUsername(String username);
}
