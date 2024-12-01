package com.sportfemme.en_avant_toutes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sportfemme.en_avant_toutes.model.Categorie;


@Service
public interface CategorieService {
    public List<Categorie> findAll();
    public Categorie addCategorie(String name);
    public Categorie findById(Long id);
     /* 
    
    public Optional<Categorie> findByName(CategorieEnum name);
    public Optional<Categorie> getById(Long id);
    public Categorie save(Categorie categorie);
    public void addCategorie(Long id,Categorie categorie);
    public void addSousCategorie(Long id, SousCategorie sousCategorie);
    public void addVideo(Long id, Video video);
*/

}