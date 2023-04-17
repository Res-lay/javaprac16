package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.User;
import com.example.demo.service.CustomUserDetailsService;

@Controller
public class RegistrationController {

    @Autowired
    private CustomUserDetailsService userAppService;

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @GetMapping("/reg")
    public String getRegistrationPage(@ModelAttribute("user") User user) {
        return "registration";
    }

    @PostMapping("/reg")
    public String signUpUser(@ModelAttribute("user") User user) {
        return userAppService.signUpUser(user);
    }
}
