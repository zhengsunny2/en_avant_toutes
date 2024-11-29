package com.sportfemme.en_avant_toutes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .authorizeHttpRequests(auth -> auth
            .requestMatchers("/contact","/inscription/register","/inscription/login", "/index").permitAll() 
            .anyRequest().authenticated()  
            )
            .formLogin(form -> form
                .loginPage("/inscription/login") 
                .permitAll()  
            )
            .logout(logout -> logout.permitAll());  
    return http.build();
    }
    

    

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
