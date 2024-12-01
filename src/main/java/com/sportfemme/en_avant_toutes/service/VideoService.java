package com.sportfemme.en_avant_toutes.service;


import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sportfemme.en_avant_toutes.model.Categorie;
import com.sportfemme.en_avant_toutes.model.SousCategorie;
import com.sportfemme.en_avant_toutes.model.Video;



@Service
public interface VideoService {
    public Video findById(Long id);
    public Video saveVideo(String titre, String description,Long categorieId, Long sousCategorieId, MultipartFile videoFile)throws IOException ;
            /* 
    public void saveVideo(String fullPath);
   public List<Video> findBySousCategorie_Categorie(Categorie categorie);
   public List<Video> findBySousCategorie(SousCategorie parent);
    public List<Video> getVideosByPath(String path);

    public Video save(Video video);
    public Video edit(Video video);
    public List<Video> findAll();
    public Video findByTitre(String titre);
    public void delete(String titre);
    public List<Video> findVideosByCategorieId(Long categorieId);
*/
    
}
