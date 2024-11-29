package com.sportfemme.en_avant_toutes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.sportfemme.en_avant_toutes.dto.UserRegisterDTO;
import com.sportfemme.en_avant_toutes.model.User;
import com.sportfemme.en_avant_toutes.repository.UserRepository;

import com.sportfemme.en_avant_toutes.service.UserService;




@Service
@Component
public class UserServiceImpl  implements UserService {
    @Autowired
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


@Override
public User registerUser(UserRegisterDTO userRegisterDTO){
        User user = new User();
        user.setUsername(userRegisterDTO.getUsername());
        user.setPassword(hashPassword(userRegisterDTO.getPassword())); 
        return userRepository.save(user);
    }

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username,password);
    }


    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    private String hashPassword(String password) {
        return new BCryptPasswordEncoder().encode(password);
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
        return userRepository.findAll()
        .stream()
        .filter(u -> u.getUsername().equalsIgnoreCase(username))
        .findFirst()
        .orElse(null);
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

