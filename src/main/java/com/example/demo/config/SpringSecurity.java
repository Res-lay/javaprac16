package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity{
    
    @Bean
    @SuppressWarnings("deprecation")
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http
            .csrf().disable()
            .authorizeRequests()
            .anyRequest().authenticated();
        http
            .formLogin()
            .permitAll()
        .and()
            .logout()
            .permitAll();
        
        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}