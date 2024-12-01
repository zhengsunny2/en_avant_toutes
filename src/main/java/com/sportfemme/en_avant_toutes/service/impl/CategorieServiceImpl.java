package com.sportfemme.en_avant_toutes.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportfemme.en_avant_toutes.model.Categorie;
import com.sportfemme.en_avant_toutes.model.SousCategorie;
import com.sportfemme.en_avant_toutes.repository.CategorieRepository;
import com.sportfemme.en_avant_toutes.repository.SousCategorieRepository;
import com.sportfemme.en_avant_toutes.service.CategorieService;

import java.util.List;

@Service
@Transactional
public class CategorieServiceImpl implements CategorieService{

    private final CategorieRepository categorieRepository;
    private final SousCategorieRepository sousCategorieRepository;

    public CategorieServiceImpl(CategorieRepository categorieRepository, SousCategorieRepository sousCategorieRepository) {
        this.categorieRepository = categorieRepository;
        this.sousCategorieRepository = sousCategorieRepository;
    }
    @Override
    public Categorie addCategorie(String name) {
        Categorie categorie = new Categorie();
        categorie.setName(name);
        return categorieRepository.save(categorie);
    }
/* 
    public SousCategorie addSousCategorie(Long categorieId,String name,SousCategorie sousCategorie) {
        Categorie categorie = categorieRepository.findById(categorieId)
                .orElseThrow(() -> new IllegalArgumentException("Categorie not found"));
        sousCategorie.setName(name);
        sousCategorie.setCategorie(categorie);
        return sousCategorieRepository.save(sousCategorie);
    }
*/
@Override
    public List<Categorie> findAll() {
        return categorieRepository.findAll();
    }

    @Override
public Categorie findById(Long id) {
    Categorie categorie = categorieRepository.findById(id).orElseThrow(() -> new RuntimeException("Categorie not found"));
    // Lazy-loaded collection will be initialized here
    return categorie;
}
    
}


/* 

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sportfemme.en_avant_toutes.model.Categorie;

import com.sportfemme.en_avant_toutes.repository.CategorieRepository;

import com.sportfemme.en_avant_toutes.service.CategorieService;
import com.sportfemme.en_avant_toutes.utils.enums.CategorieEnum;


@Service
@Component
public class CategorieServiceImpl implements CategorieService {

    private final CategorieRepository categorieRepository;

    @Autowired
    public CategorieServiceImpl(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    @Override
    @Transactional
     public Optional<Categorie> findByName(CategorieEnum name){
        return categorieRepository.findByName(name);
}



     @Override
     @Transactional
     public List<Categorie> findAll() {
         return categorieRepository.findAll();
     }
     @Override
     @Transactional
     public Optional<Categorie> getById(Long id) {
         return categorieRepository.findById(id);
      }

      @Override
      public Categorie save(Categorie categorie) {
          return categorieRepository.save(categorie);
      }
    }


    private final CategorieRepository categorieRepository;
    private final SousCategorieRepository sousCategorieRepository;
    private final VideoRepository videoRepository;

    @Autowired
    public CategorieServiceImpl(CategorieRepository categorieRepository,SousCategorieRepository sousCategorieRepository,
        VideoRepository videoRepository) {
        this.categorieRepository = categorieRepository;
        this.sousCategorieRepository = sousCategorieRepository;
        this.videoRepository = videoRepository;
    }

    @Override
    public void addCategorie(Long id,Categorie categorie) {
        Categorie parent = categorieRepository.findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Categorie not found"));
        categorie.setParent(parent);
        parent.getCategories().add(categorie);
        categorieRepository.save(parent);
    }

    @Override
    public void addSousCategorie(Long id, SousCategorie sousCategorie) {
        Categorie categorie = categorieRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Categorie not found"));
            sousCategorie.setCategorie(categorie);
        categorie.getSousCategories().add(sousCategorie);
        sousCategorieRepository.save(sousCategorie);
    }

       @Override
    public void addVideo(Long id, Video video) {
        Categorie categorie = categorieRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Categorie not found"));
        video.setCategorie(categorie);
        categorie.getVideos().add(video);
        videoRepository.save(video);
    }

    @Override
    public Categorie save(Categorie categorie) {
        if (categorie.getParent() != null) {
            Categorie parent = categorieRepository.findById(categorie.getParent().getId())
                .orElseThrow(() -> new IllegalArgumentException("Parent Categorie not found"));
            categorie.setParent(parent);
        }
        return categorieRepository.save(categorie);
    }

    @Override
    @Transactional
    public Optional<Categorie> findByName(String name) {
        return categorieRepository.findAll().stream()
            .filter(categorie -> categorie.getName().equalsIgnoreCase(name))
            .findFirst();
    }

    @Override
    @Transactional
    public Categorie getById(Long id) {
        Categorie categorie = categorieRepository.findById(id).orElseThrow();
        // Lazy-loaded collection will be initialized here
        return categorie;
    }

}
    */
