package com.sportfemme.en_avant_toutes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.sportfemme.en_avant_toutes.model.Categorie;
import com.sportfemme.en_avant_toutes.model.SousCategorie;



@Repository
@RepositoryRestResource
public interface SousCategorieRepository extends JpaRepository<SousCategorie, Long> {

    List<SousCategorie> findByCategorieId(Long categorieId);
    public Optional<SousCategorie> findByNameAndParentAndCategorie(String name,SousCategorie  parent,Categorie categorie);
}