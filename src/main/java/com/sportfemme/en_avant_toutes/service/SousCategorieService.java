package com.sportfemme.en_avant_toutes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sportfemme.en_avant_toutes.model.Categorie;
import com.sportfemme.en_avant_toutes.model.SousCategorie;


@Service
public interface SousCategorieService {
  public Optional<SousCategorie> findByNameAndParentAndCategorie(String name,SousCategorie  parent,Categorie categorie);
    public List<SousCategorie> findAll();
    public SousCategorie save(SousCategorie sousCategorie);
    public List<SousCategorie> findByCategorieId(Long categorieId);

      public Optional<SousCategorie> findById(Long id);
       public Optional<SousCategorie> findByName(String name);

 //   public void addVideo(Long id, Video video);
// public void addSousCategorie(Long id, SousCategorie sousCategorie);

}
