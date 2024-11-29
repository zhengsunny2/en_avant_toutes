package com.sportfemme.en_avant_toutes.service.impl;






import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sportfemme.en_avant_toutes.model.Categorie;
import com.sportfemme.en_avant_toutes.model.SousCategorie;
import com.sportfemme.en_avant_toutes.model.Video;
import com.sportfemme.en_avant_toutes.repository.CategorieRepository;
import com.sportfemme.en_avant_toutes.repository.SousCategorieRepository;
import com.sportfemme.en_avant_toutes.repository.VideoRepository;


import com.sportfemme.en_avant_toutes.service.VideoService;
import com.sportfemme.en_avant_toutes.utils.enums.CategorieEnum;
@Service
@Component
public class VideoServiceImpl implements VideoService {

    @Autowired
    private final VideoRepository videoRepository;
    private CategorieRepository categorieRepository;
    private SousCategorieRepository sousCategorieRepository;
    public VideoServiceImpl(VideoRepository videoRepository,CategorieRepository categorieRepository, SousCategorieRepository sousCategorieRepository) {
        this.videoRepository = videoRepository;
        this.categorieRepository = categorieRepository;
        this.sousCategorieRepository = sousCategorieRepository;
    }

    @Override
    public void saveVideo(String fullPath) {
        String[] parts = fullPath.split("/");
        if (parts.length < 4) {
            throw new IllegalArgumentException("Invalid path format. Expected format: /Enum/SubDir/SubSubDir/video.mp4");
        }
        String categorieName = parts[1];
        CategorieEnum categorieEnum = CategorieEnum.valueOf(categorieName.toUpperCase());
        Categorie categorie = categorieRepository.findByName(categorieEnum)
                .orElseThrow(() -> new RuntimeException("Categorie not found: " + categorieName));

        SousCategorie parent = null;
        for (int i = 2; i < parts.length - 1; i++) {
            String sousCategorieName = parts[i];
            parent = findOrCreateSousCategorie(sousCategorieName, parent, categorie);
        }


        String videoName = parts[parts.length - 1];
        String videoPath = fullPath;
        Video video = new Video();
        video.setName(videoName);
        video.setPath(videoPath);
        video.setSousCategorie(parent);
        videoRepository.save(video);
    }

    private SousCategorie findOrCreateSousCategorie(String name, SousCategorie parent, Categorie categorie) {
        return sousCategorieRepository.findByNameAndParentAndCategorie(name, parent, categorie)
                .orElseGet(() -> {
                    SousCategorie newDir = new SousCategorie();
                    newDir.setName(name);
                    newDir.setParent(parent);
                    newDir.setCategorie(categorie);
                    return sousCategorieRepository.save(newDir);
                });
    }
    @Override
public List<Video> getVideosByPath(String path) {
    String[] parts = path.split("/");
    if (parts.length < 2) {
        throw new IllegalArgumentException("Invalid path format.");
    }

    String categorieName = parts[1];
    CategorieEnum categorieEnum = CategorieEnum.valueOf(categorieName.toUpperCase());
    Categorie categorie = categorieRepository.findByName(categorieEnum)
            .orElseThrow(() -> new RuntimeException("Categorie not found: " + categorieName));


    SousCategorie parent = null;
    for (int i = 2; i < parts.length; i++) {
        String dirName = parts[i];
        parent = sousCategorieRepository.findByNameAndParentAndCategorie(dirName, parent, categorie)
                .orElseThrow(() -> new RuntimeException("SousCategorie not found: " + dirName));
    }

    return videoRepository.findBySousCategorie(parent);
}


@Override
public List<Video> findBySousCategorie_Categorie(Categorie categorie){
return videoRepository.findBySousCategorie_Categorie(categorie);
}
@Override
   public List<Video> findBySousCategorie(SousCategorie parent){
    return videoRepository.findBySousCategorie(parent);
   }


}

/* 

    @Override
public List<Video> findVideosByCategorieId(Long categorieId) {
    return videoRepository.findByCategorieId(categorieId);
}
    @Override
    public Video save(Video video){
    Video v = this.findByTitre(video.getTitre());
       if(v==null) {
           videoRepository.save(video);
           return video;
       }

       return null;
   }
   
   @Override
    public Video edit(Video video){
       if(video!=null) {
        Video v = this.findByTitre(video.getTitre());
           delete(v.getTitre());
           videoRepository.save(video);
           return video;
       }
       return null;
   }

   @Override
    public List<Video> findAll(){
        return videoRepository.findAll();

    }
    @Override
    public Video findByTitre(String titre){
        for(Video video : videoRepository.findAll()){
            if(video.getTitre().equals(titre)){
                return video;
            }
        }
            return null;
    }
    @Override
    public void delete(String titre){
        videoRepository.delete(findByTitre(titre));

    }

    @Override
public Video findById(Long id) {
    return videoRepository.findById(id).orElse(null);
}
}

*/
