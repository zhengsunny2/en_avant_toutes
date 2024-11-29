package com.sportfemme.en_avant_toutes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sportfemme.en_avant_toutes.model.Role;
import com.sportfemme.en_avant_toutes.repository.RoleRepository;
import com.sportfemme.en_avant_toutes.service.RoleService;

@Component
public class RoleServiceImpl implements RoleService {
    @Autowired
    private final RoleRepository roleRepository;
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }
    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }
    
}
