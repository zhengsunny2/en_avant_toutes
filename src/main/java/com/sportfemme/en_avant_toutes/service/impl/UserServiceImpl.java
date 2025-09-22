package com.sportfemme.en_avant_toutes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.sportfemme.en_avant_toutes.dto.UserRegisterDTO;
import com.sportfemme.en_avant_toutes.model.Role;
import com.sportfemme.en_avant_toutes.model.User;
import com.sportfemme.en_avant_toutes.repository.RoleRepository;
import com.sportfemme.en_avant_toutes.repository.UserRepository;

import com.sportfemme.en_avant_toutes.service.UserService;




@Service
@Component
public class UserServiceImpl  implements UserService {
    @Autowired
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserServiceImpl(RoleRepository roleRepository,UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


@Override
public User registerUser(UserRegisterDTO userRegisterDTO){
    Role userRole = roleRepository.findByName("USER");
        User user = new User();
        user.setUsername(userRegisterDTO.getUsername());
        user.setPassword(hashPassword(userRegisterDTO.getPassword())); 
        user.setActive(true);
        user.setRole(userRole);
        return userRepository.save(user);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = userRepository.findByUsername(username);
    if (user == null || !passwordEncoder.matches(password, user.getPassword())) { 
        throw new RuntimeException("Invalid credentials");
    }

    return user;
}
      
private String hashPassword(String password) {
    return new BCryptPasswordEncoder().encode(password);
}


    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
    
    @Override
    public User findByEmailAndPassword(String email,String password) {
        return userRepository.findByEmailAndPassword(email,password);
    }
    @Override
   public User findByUsername(String username) {
    return userRepository.findByUsername(username);
}
  
    @Override
    public void delete(String email) {
        userRepository.delete(userRepository.findByEmail(email));
    }
    @Override
    public boolean active(String username) {
        User user = userRepository.findByUsername(username);
        user.setActive(true);
        userRepository.save(user);
        return true;
    }


    @Override
    public User findById(Long id) {
        return userRepository.findById(id).get();
    }





}

