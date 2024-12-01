package com.sportfemme.en_avant_toutes.service.impl;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.sportfemme.en_avant_toutes.model.Categorie;
import com.sportfemme.en_avant_toutes.model.SousCategorie;
import com.sportfemme.en_avant_toutes.repository.CategorieRepository;
import com.sportfemme.en_avant_toutes.repository.SousCategorieRepository;
import com.sportfemme.en_avant_toutes.repository.VideoRepository;

import com.sportfemme.en_avant_toutes.service.SousCategorieService;


@Service
@Component
public class SousCategorieServiceImpl implements SousCategorieService {
     @Autowired
    private final SousCategorieRepository sousCategorieRepository;
    private final CategorieRepository categorieRepository;
     private final VideoRepository videoRepository;
  
    public SousCategorieServiceImpl(CategorieRepository categorieRepository,SousCategorieRepository sousCategorieRepository, VideoRepository videoRepository) {
        this.categorieRepository = categorieRepository;
        this.sousCategorieRepository = sousCategorieRepository;
        this.videoRepository = videoRepository;
       
    }

    @Override
public SousCategorie findById(Long id) {
    return sousCategorieRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("SousCategorie with ID " + id + " not found"));
}

@Override
public List<SousCategorie> findByCategorieId(Long categorieId) {
    List<SousCategorie> sousCategories = sousCategorieRepository.findAll()
        .stream()
        .filter(sousCategorie -> sousCategorie.getCategorie().getId().equals(categorieId))
        .toList();
    if (sousCategories.isEmpty()) {
        addSousCategorie(categorieId, "Default");

    }

    return sousCategories;
}



@Override
public List<SousCategorie> findAll(){
    return sousCategorieRepository.findAll();
}

@Override
public SousCategorie addSousCategorie(Long categorieId,String name){
    Categorie categorie = categorieRepository.findById(categorieId)
    .orElseThrow(() -> new NoSuchElementException("Categorie with ID " + categorieId + " not found"));
SousCategorie newSousCategorie = new SousCategorie();
    newSousCategorie.setCategorie(categorie);  
    newSousCategorie.setName(name);  
    sousCategorieRepository.save(newSousCategorie);
    return newSousCategorie;
}
}
/*
@Override
    public Optional<SousCategorie> findByNameAndParentAndCategorie(String name,SousCategorie  parent,Categorie categorie) {
       return sousCategorieRepository.findByNameAndParentAndCategorie(name, parent, categorie);
    }


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


    }

 */

