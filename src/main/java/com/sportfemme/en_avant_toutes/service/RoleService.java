package com.sportfemme.en_avant_toutes.service;

import java.util.List;
import com.sportfemme.en_avant_toutes.model.Role;
import org.springframework.stereotype.Service;

@Service
public interface RoleService {
    public List<Role> findAll();
    public Role save(Role role);

}
