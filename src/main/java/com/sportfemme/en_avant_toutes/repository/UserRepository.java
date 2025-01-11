package com.sportfemme.en_avant_toutes.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sportfemme.en_avant_toutes.model.User;


public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmailAndPassword(String email,String password);
    public User findByEmail(String email);
    public User findByUsernameAndPassword(String username,String password);
    public User findByUsername(String username);
    public User save(User user);
    

}
