package com.sportfemme.en_avant_toutes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.sportfemme.en_avant_toutes.model.Role;

@Repository
@RepositoryRestResource
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
