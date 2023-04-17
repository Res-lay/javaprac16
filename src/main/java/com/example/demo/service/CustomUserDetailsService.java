package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.models.User;
import com.example.demo.repository.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findUserByName(username);
        if(user == null){
            throw new UsernameNotFoundException("");
        }
        UserDetails userDetails = 
            org.springframework.security.core.userdetails.User.builder()
                .username(user.getUsername())
                .password(user.getPassword())
                .roles("USER")
                .build();

        return userDetails;
    }

    public String signUpUser(User user) {
        boolean exist = userRepo.findUserByName(user.getUsername()) != null;
        if (exist) {
            throw new IllegalStateException("already exists");
        }
        String password = user.getPassword();
        user.setPassword(passwordEncoder.encode(password));
        userRepo.save(user);
        return "login";
    }
}
