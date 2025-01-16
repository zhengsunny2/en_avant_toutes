package com.sportfemme.en_avant_toutes.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sportfemme.en_avant_toutes.model.SousCategorie;
import com.sportfemme.en_avant_toutes.model.User;
import com.sportfemme.en_avant_toutes.model.Video;

import com.sportfemme.en_avant_toutes.repository.SousCategorieRepository;
import com.sportfemme.en_avant_toutes.repository.UserRepository;
import com.sportfemme.en_avant_toutes.repository.VideoRepository;
import com.sportfemme.en_avant_toutes.service.VideoService;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.NoSuchElementException;


@Service
public class VideoServiceImpl implements VideoService {

    @Autowired
    private final SousCategorieRepository sousCategorieRepository;
    private final UserRepository userRepository;
     private final VideoRepository videoRepository;

     @Value("${video_static.upload.path}")
     private String videoUploadPath;
 
 
  
    public VideoServiceImpl(UserRepository userRepository,SousCategorieRepository sousCategorieRepository, VideoRepository videoRepository) {
        this.userRepository=userRepository;
        this.sousCategorieRepository = sousCategorieRepository;
        this.videoRepository = videoRepository; 
    }

    @Override
    public Video findById(Long id) {
        return videoRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("video with ID " + id + " not found"));
}
@Override
public List<Video> findByUserId(Long userId) {
    return videoRepository.findByUserId(userId);

}

@Override
public String saveVideoFile(MultipartFile videoFile) throws IOException {
    String fileName = System.currentTimeMillis() + "_" + videoFile.getOriginalFilename();
    Path storageDir = Path.of(videoUploadPath);
    
    // Ensure the directory exists
    if (!Files.exists(storageDir)) {
        Files.createDirectories(storageDir);
    }
    
    Path filePath = storageDir.resolve(fileName);

    // Save the file using Files.copy
    try (InputStream inputStream = videoFile.getInputStream()) {
        Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
    } catch (IOException e) {
        throw new IOException("Failed to save video file: " + e.getMessage(), e);
    }

    return "/files/" +fileName;
}

public Path getVideoPath(String fileName) {
    return Path.of(videoUploadPath).resolve(fileName);
}
  
    
    @Override
    public Video saveVideo(String titre, String description, Long userId, Long sousCategorieId, String videoPath) throws IOException {
       SousCategorie sousCategorie = sousCategorieRepository.findById(sousCategorieId)
        .orElseThrow(() -> new NoSuchElementException("SousCategorie with ID " + sousCategorieId + " not found"));
        User user=userRepository.findById(userId) 
        .orElseThrow(() -> new NoSuchElementException("User with ID " + sousCategorieId + " not found"));
        


        // String  videoPath = saveVideoFile(videoFile);
        Video video = new Video();
        video.setTitre(titre);
        video.setDescription(description);
        video.setPath(videoPath);
        video.setUser(user);
        video.setSousCategorie(sousCategorie);
        videoRepository.save(video);
        return video;
    }

}






/* 

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


}

*/
