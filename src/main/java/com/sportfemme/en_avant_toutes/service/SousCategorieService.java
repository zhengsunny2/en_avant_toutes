package com.sportfemme.en_avant_toutes.service;

import java.util.List;


import org.springframework.stereotype.Service;


import com.sportfemme.en_avant_toutes.model.SousCategorie;


@Service
public interface SousCategorieService {
  public SousCategorie findById(Long id);
  public List<SousCategorie> findAll();
  public List<SousCategorie> findByCategorieId(Long categorieId);
  public SousCategorie addSousCategorie(Long categorieId,String name);
  /* 
  public Optional<SousCategorie> findByNameAndParentAndCategorie(String name,SousCategorie  parent,Categorie categorie);
 
    public SousCategorie save(SousCategorie sousCategorie);
 

      public Optional<SousCategorie> findById(Long id);
       public Optional<SousCategorie> findByName(String name);

  public void addVideo(Long id, Video video);
public void addSousCategorie(Long id, SousCategorie sousCategorie);
*/

}
