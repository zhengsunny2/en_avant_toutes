package com.sportfemme.en_avant_toutes.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportfemme.en_avant_toutes.api.RestAPIResponse;
import com.sportfemme.en_avant_toutes.dto.UserLoginDTO;
import com.sportfemme.en_avant_toutes.dto.UserRegisterDTO;
import com.sportfemme.en_avant_toutes.model.User;
import com.sportfemme.en_avant_toutes.res.AuthenticationResponse;
import com.sportfemme.en_avant_toutes.service.UserService;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
@Controller
@RequestMapping("/inscription")
public class AuthController {

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String inscription(){
        return "pages/inscription";
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody UserRegisterDTO userRegisterDTO) {
        try {
            User user=userService.registerUser(userRegisterDTO);
            return ResponseEntity.ok("User registered successfully");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserLoginDTO userLoginDTO) {
        try {
            User user = userService.findByUsernameAndPassword(userLoginDTO.getUsername(), userLoginDTO.getPassword());
            return ResponseEntity.ok("Login successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}

/* 
    @GetMapping("/inscription")
    public ResponseEntity<?> registerInfo() {
        return ResponseEntity.status(405).body(new RestAPIResponse(405, "Please use POST method for registration."));
    }

    @GetMapping("/login")
    public ResponseEntity<?> loginInfo() {
        return ResponseEntity.status(405).body(new RestAPIResponse(405, "Please use POST method for login."));
    }
}

/* 
    @PostMapping("/user_add")
    public ResponseEntity<RestAPIResponse> save(@RequestBody @Valid User user) {
        userService.save(user);
        return ResponseEntity.ok(new RestAPIResponse(200,"User added successfully"));
    }
}

    


    @GetMapping("/user_list")
    public String User(@RequestBody User user,Model model){
       List<User> users=userService.findAll();
       model.addAttribute("users", users);
        return "redirect:/admin";
    }
        */
    

    

