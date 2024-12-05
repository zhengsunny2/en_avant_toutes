package com.sportfemme.en_avant_toutes.controller;



import java.net.URI;
import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportfemme.en_avant_toutes.dto.UserDTO;
import com.sportfemme.en_avant_toutes.dto.UserLoginDTO;
import com.sportfemme.en_avant_toutes.dto.UserRegisterDTO;
import com.sportfemme.en_avant_toutes.model.User;
import com.sportfemme.en_avant_toutes.service.UserService;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/inscription")
public class AuthController {

    @Autowired
    private UserService userService;



    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        try {
            User user=userService.registerUser(userRegisterDTO);
             Map<String, String> response = new HashMap<>();
        response.put("message", "User registered successfully");
        response.put("token", "generated-auth-token");
        return ResponseEntity.ok()
    .contentType(MediaType.APPLICATION_JSON)
    .body(response);
        } catch (Exception e) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "User registration failed: An unexpected error occurred");
            return ResponseEntity.badRequest()
                    .contentType(MediaType.APPLICATION_JSON)
                    .body(response);
        }
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserLoginDTO userLoginDTO, HttpSession session) {
        try {
            User user = userService.findByUsernameAndPassword(userLoginDTO.getUsername(), userLoginDTO.getPassword());
            session.setAttribute("loggedInUser", userLoginDTO);
    
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Login successful");
            response.put("token", "generated-auth-token");
            response.put("redirect", "/video");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("message", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
    

    }
    
   



/* 

    @GetMapping("/user_list")
    public String User(@RequestBody User user,Model model){
       List<User> users=userService.findAll();
       model.addAttribute("users", users);
        return "redirect:/admin";
    }
        */
    

    

