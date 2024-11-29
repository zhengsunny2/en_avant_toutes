package com.sportfemme.en_avant_toutes.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportfemme.en_avant_toutes.model.Categorie;
import com.sportfemme.en_avant_toutes.model.SousCategorie;

import com.sportfemme.en_avant_toutes.repository.SousCategorieRepository;
import com.sportfemme.en_avant_toutes.repository.VideoRepository;
import com.sportfemme.en_avant_toutes.service.SousCategorieService;


@Service
@Component
public class SousCategorieServiceImpl implements SousCategorieService {
     @Autowired
    private final SousCategorieRepository sousCategorieRepository;
   
     private final VideoRepository videoRepository;
  
    public SousCategorieServiceImpl(SousCategorieRepository sousCategorieRepository, VideoRepository videoRepository) {
        this.sousCategorieRepository = sousCategorieRepository;
        this.videoRepository = videoRepository;
       
    }

@Override
    public Optional<SousCategorie> findByNameAndParentAndCategorie(String name,SousCategorie  parent,Categorie categorie) {
       return sousCategorieRepository.findByNameAndParentAndCategorie(name, parent, categorie);
    }

/*
        @Override
    public void addSousCategorie(Categorie categorie, SousCategorie sousCategorie) {
        SousCategorie s = sousCategorieRepository.findById(sousCategorie.getId())
            .orElseThrow(() -> new IllegalArgumentException("Categorie not found"));
            sousCategorie.setCategorie(categorie);
        categorie.getSousCategories().add(sousCategorie);
        sousCategorieRepository.save(sousCategorie);
    }
   

      @Override
    public void addVideo(Long id, Video video) {
        SousCategorie sousCategorie = sousCategorieRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Categorie not found"));
        video.setSousCategorie(sousCategorie);
        sousCategorie.getVideos().add(video);
        videoRepository.save(video);
    }
 */
    

    @Override
    public List<SousCategorie> findAll(){
        return sousCategorieRepository.findAll();
    }

    @Override
    public SousCategorie save(SousCategorie sousCategorie){
          sousCategorieRepository.save(sousCategorie);
           return sousCategorie;
   }

   @Override
   public Optional<SousCategorie> findById(Long id) {
    return sousCategorieRepository.findById(id); // Assuming you're using a JpaRepository
}

   @Override
    @Transactional
    public Optional<SousCategorie> findByName(String name) {
        return sousCategorieRepository.findAll().stream()
            .filter(sousCategorie -> sousCategorie.getName().equalsIgnoreCase(name))
            .findFirst();
    }

    @Override
    public List<SousCategorie> findByCategorieId(Long categorieId){
        return sousCategorieRepository.findByCategorieId(categorieId);
    }
    }



