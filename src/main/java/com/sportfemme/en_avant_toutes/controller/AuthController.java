package com.sportfemme.en_avant_toutes.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.sportfemme.en_avant_toutes.dto.UserLoginDTO;
import com.sportfemme.en_avant_toutes.dto.UserRegisterDTO;
import com.sportfemme.en_avant_toutes.model.User;
import com.sportfemme.en_avant_toutes.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    // 注册
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        try {
            User user = userService.registerUser(userRegisterDTO);
            Map<String, Object> response = new HashMap<>();
            response.put("message", "User registered successfully");
            response.put("userId", user.getId());
            response.put("redirect", "/profil/" + user.getId());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("message", "Registration failed: " + e.getMessage()));
        }
    }

    // 登录
        // @PostMapping("/login")
        // public ResponseEntity<?> login(@RequestBody UserLoginDTO userLoginDTO, HttpSession session) {
        //     try {
        //         Authentication authentication = authenticationManager.authenticate(
        //                 new UsernamePasswordAuthenticationToken(
        //                         userLoginDTO.getUsername(),
        //                         userLoginDTO.getPassword()
        //                 )
        //         );

        //         SecurityContextHolder.getContext().setAuthentication(authentication);
        //         User user = userService.findByUsername(userLoginDTO.getUsername());
        //         session.setAttribute("user", user); // 保存用户信息到 session

        //         return ResponseEntity.ok(Map.of(
        //                 "message", "Login successful",
        //                 "redirect", "/profil/" + user.getId()
        //         ));
        //     } catch (Exception e) {
        //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
        //                 .body(Map.of("message", "Invalid username or password"));
        //     }
        // }
}
