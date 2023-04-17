package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SpringSecurity{

    @Autowired
    private CustomUserDetailsService userAppService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf()
                .disable().cors()
                .disable().authorizeHttpRequests()
                .requestMatchers("/login", "/reg").permitAll()
                .anyRequest().authenticated()
               .and().formLogin()
                // .and().logout()
                .and().userDetailsService(userAppService);
        return http.build();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userAppService);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }
}
