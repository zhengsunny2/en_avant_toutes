package com.sportfemme.en_avant_toutes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.sportfemme.en_avant_toutes.dto.UserLoginDTO;
import com.sportfemme.en_avant_toutes.model.User;
import com.sportfemme.en_avant_toutes.model.Video;
import com.sportfemme.en_avant_toutes.service.UserService;
import com.sportfemme.en_avant_toutes.service.VideoService;

import jakarta.servlet.http.HttpSession;


import java.util.HashMap;
import java.util.Map;

@Controller
public class VideoController {
    @Autowired
    private final VideoService videoService;
    private  UserService userService;

    public VideoController(UserService userService,VideoService videoService) {
        this.videoService = videoService;
        this.userService=userService;
    }

    

    @PostMapping("/{sousCategorieId}/add-video")
    public ResponseEntity<?> addVideo(
            @PathVariable Long sousCategorieId, 
            @RequestParam("titre") String titre,
            @RequestParam("description") String description,
            @RequestParam("videoFile") MultipartFile videoFile,
            HttpSession session) {
    
        // // get UserLoginDTO from session
        // UserLoginDTO loggedInUserDTO = (UserLoginDTO) session.getAttribute("loggedInUser");
        // if (loggedInUserDTO == null) {
        //     return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not logged in");
        // }
    
        try {
            // UserService get user 
            User loggedInUser = (User) session.getAttribute("loggedInUser")
    
            // save video and get the url of video
            String videoPageUrl = videoService.saveVideoFile(videoFile);
            if (videoPageUrl == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body(Map.of("error", "Failed to save video."));
            }
    
            //save video in the SQL
            Video video = videoService.saveVideo(titre, description, loggedInUser.getId(), sousCategorieId, videoFile);
    
            //response
            Map<String, Object> response = new HashMap<>();
            response.put("videoId", video.getId());
            response.put("username", video.getUser().getUsername());
            response.put("videoPageUrl", videoPageUrl);
            response.put("success", true);
            response.put("message", "Video added successfully.");
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    Map.of("success", false, "message", "Invalid input: " + e.getMessage())
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    Map.of("success", false, "message", "Error adding video: " + e.getMessage())
            );
        }
    }
    
}



/* 
import java.util.List;


import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;


import com.sportfemme.en_avant_toutes.model.Video;

import com.sportfemme.en_avant_toutes.service.VideoService;


@RestController
@RequestMapping("/api/videos")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @PostMapping("/save")
    public ResponseEntity<String> saveVideo(@RequestParam String path) {
        videoService.saveVideo(path);
        return ResponseEntity.ok("Video saved successfully");
    }

    @GetMapping("/list")
    public ResponseEntity<List<String>> listVideos(@RequestParam String path) {
        List<Video> videos = videoService.getVideosByPath(path);
        List<String> videoPaths = videos.stream().map(Video::getPath).collect(Collectors.toList());
        return ResponseEntity.ok(videoPaths);
    }
}


/* 
@CrossOrigin
@Controller
public class VideoController {
    private final VideoService videoService;
    private CategorieService categorieService;
    private SousCategorieService sousCategorieService;
   @Autowired
    public VideoController(VideoService videoService,CategorieService categorieService,SousCategorieService sousCategorieService) {
        this.videoService = videoService;
        this.categorieService=categorieService;
        this.sousCategorieService=sousCategorieService;
    }

  @GetMapping("/categories")
    @ResponseBody
    public List<Categorie> findAll() {
        return categorieService.findAll();
    }

    @GetMapping("/subcategories/{categoryId}")
    @ResponseBody
    public List<SousCategorie> getSubCategories(@PathVariable Long categorieId) {
        return sousCategorieService.findByCategorieId(categorieId);
    }
    @GetMapping("/video")
    public String video() {
        return "pages/video";
    }

    @ResponseBody
    @PostMapping("/video_add")
    public ResponseEntity<Map<String, String>> uploadVideo(
            @RequestParam("titre") String titre,
            @RequestParam("description") String description,
            @RequestParam("categorie") Categorie categorie,
            @RequestParam("sousCategorie") SousCategorie sousCategorie,
            @RequestParam("videoFile") MultipartFile videoFile) {
    
        try {
          
            String videoPageUrl = saveVideoFile(videoFile);
            if (videoPageUrl == null) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("error", "Failed to save video."));
            }

        
    
          
            Video video = new Video();
            video.setTitre(titre);
            video.setDescription(description);
            video.setUrl(videoPageUrl);
            video.setCategorie(categorie);
            video.setSousCategorie(sousCategorie);
            videoService.save(video);
    
           
            Map<String, String> responseMap = new HashMap<>();
            responseMap.put("videoId", String.valueOf(video.getId())); 
            responseMap.put("videoPageUrl", videoPageUrl);
            return ResponseEntity.ok(responseMap);
    
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("error", "Failed to save video."));
            }
    }
    

    @GetMapping("/video/{id}")
    public String videoDetail(@PathVariable Long id, Model model) {
        Video video = videoService.findById(id);
        if (video != null) {
            model.addAttribute("video", video);
            model.addAttribute("videoPageUrl", video.getUrl());
            return "pages/videoDetail";
        } else {
            return "pages/videoNotFound";
        }
    }

    @Value("${video.upload.path}")
    private String videoUploadPath;

    public String saveVideoFile(MultipartFile videoFile) {
        // MultipartFile videoFile = uploadForm.getFichier();
        String fileName = videoFile.getOriginalFilename();
        Path filePath = Paths.get(videoUploadPath, fileName);
        
    
        try {
            Files.createDirectories(filePath.getParent());
    
            try (InputStream in = videoFile.getInputStream();
                 OutputStream out = new FileOutputStream(filePath.toFile())) {
                  //  videoService.create(uploadForm.getCategorieId(), uploadForm.getTitre(), fileName);
    
                byte[] buffer = new byte[1024];
                int len;
                while ((len = in.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
            }
    
            return "/assets/video/" + fileName;
    
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
} 

*/