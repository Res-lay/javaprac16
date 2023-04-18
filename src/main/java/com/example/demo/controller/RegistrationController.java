package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.User;
import com.example.demo.service.CustomUserDetailsService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class RegistrationController {

    @Autowired
    private CustomUserDetailsService userAppService;

    @GetMapping("/login")
    public String getLogin(){
        return "loginform";
    }

    @GetMapping("/reg")
    public String getRegistrationPage(@ModelAttribute("user") User user) {
        // ModelAndView modelAndView = new ModelAndView();
        // modelAndView.setViewName("registration.html");
        // return modelAndView;
        return "registration";
    }

    @PostMapping("/reg")
    public String signUpUser(@ModelAttribute("user") User user) {
        return userAppService.signUpUser(user);
    }
}
