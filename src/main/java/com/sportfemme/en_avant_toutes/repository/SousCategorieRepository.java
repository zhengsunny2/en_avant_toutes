package com.sportfemme.en_avant_toutes.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.sportfemme.en_avant_toutes.model.SousCategorie;



@Repository
@RepositoryRestResource
public interface SousCategorieRepository extends JpaRepository<SousCategorie, Long> {

}