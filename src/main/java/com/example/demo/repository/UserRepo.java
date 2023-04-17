package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.models.User;

public interface UserRepo extends JpaRepository<User, Long>{
    
    @Query("SELECT u FROM User u WHERE u.username = :username")
    User findUserByName(@Param("username") String username);
}
