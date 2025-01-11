package com.sportfemme.en_avant_toutes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.sportfemme.en_avant_toutes.model.Categorie;
import com.sportfemme.en_avant_toutes.model.SousCategorie;
import com.sportfemme.en_avant_toutes.model.Video;
@Repository
@RepositoryRestResource
public interface VideoRepository extends JpaRepository<Video, Long> {
    List<Video> findBySousCategorie_Categorie(Categorie categorie);
    //  List<Video> findByCategorieId(Long categorieId);

    List<Video> findBySousCategorie(SousCategorie parent);

    List<Video> findByUserId(Long userId);
}
