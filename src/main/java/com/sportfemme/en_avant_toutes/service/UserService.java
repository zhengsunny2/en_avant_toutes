package com.sportfemme.en_avant_toutes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sportfemme.en_avant_toutes.dto.UserRegisterDTO;
import com.sportfemme.en_avant_toutes.model.User;

@Service
public interface UserService {
    public User registerUser(UserRegisterDTO userRegisterDTO);
    public boolean active(String username);
    public void delete(String email);
    public User save(User user);
    public List<User> findAll();
    public User findByEmail(String email);
    public User findByEmailAndPassword(String email,String password);
    public User findByUsername(String username);
   
    public User findById(Long id);
    public User findByUsernameAndPassword(String username,String password);


}
