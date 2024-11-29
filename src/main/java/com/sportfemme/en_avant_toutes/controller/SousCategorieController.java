package com.sportfemme.en_avant_toutes.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.sportfemme.en_avant_toutes.model.Categorie;
import com.sportfemme.en_avant_toutes.model.SousCategorie;
import com.sportfemme.en_avant_toutes.service.SousCategorieService;
import com.sportfemme.en_avant_toutes.service.CategorieService;

public class SousCategorieController {
    private final SousCategorieService sousCategorieService;
    private final CategorieService categorieService;

    @Autowired
    public SousCategorieController(SousCategorieService sousCategorieService,CategorieService categorieService) {
        this.sousCategorieService = sousCategorieService;
        this.categorieService = categorieService;
        
    }

/* 
        @GetMapping("/souscategories/{categorieId}")
public ResponseEntity<SousCategorie> getSousCategorie(@PathVariable Long categorieId) {
    return sousCategorieService.findById(categorieId)
    .map(sousCategorie -> {
    
        Hibernate.initialize(sousCategorie.getVideos());
        return ResponseEntity.ok(sousCategorie);
    })
    .orElseThrow(() -> new ResourceNotFoundException("Categorie not found with categorieId " + categorieId));
}


    @PostMapping("/add-souscategorie")
public ResponseEntity<Map<String, Object>> addSousCategorie(
        @RequestParam String name,
        @RequestParam (required = false) Long categorieId) {

    SousCategorie sousCategorie = new SousCategorie();
    sousCategorie.setName(name);
    sousCategorie.setCategorie(categorieService.findById(categorieId).get());

    if (categorieId != null) {
 
        Optional<Categorie> parentCategorie = categorieService.findById(categorieId);
            parentCategorie.ifPresent(sousCategorie::setCategorie); 
    }
    sousCategorieService.save(sousCategorie);
    Map<String, Object> response = new HashMap<>();
    response.put("success", true);
    return ResponseEntity.ok(response);
}
*/

 @PostMapping("/add-directory")
    public ResponseEntity<Map<String, Object>> addDirectory(MultipartHttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();

        try {
            String categorieEnum = request.getParameter("categorieEnum");
            String categorieIdStr = request.getParameter("categorie");
            String sousCategorieIdStr = request.getParameter("sousCategorie");

            // Validate inputs
            if (categorieEnum == null || categorieEnum.trim().isEmpty()) {
                response.put("success", false);
                response.put("message", "Category type (categorieEnum) is required.");
                return ResponseEntity.badRequest().body(response);
            }

            // Check category (Categorie)
            Categorie categorie = null;
            if (categorieIdStr != null && !categorieIdStr.isEmpty()) {
                Long categorieId = Long.parseLong(categorieIdStr);
                Optional<Categorie> categorieOptional = categorieService.getById(categorieId);
                if (categorieOptional.isPresent()) {
                    categorie = categorieOptional.get();
                } else {
                    response.put("success", false);
                    response.put("message", "Category (Categorie) not found.");
                    return ResponseEntity.badRequest().body(response);
                }
            }

            // Check sousCategorie (SousCategorie)
            SousCategorie sousCategorie = null;
            if (sousCategorieIdStr != null && !sousCategorieIdStr.isEmpty()) {
                Long sousCategorieId = Long.parseLong(sousCategorieIdStr);
                Optional<SousCategorie> sousCategorieOptional = sousCategorieService.findById(sousCategorieId);
                if (sousCategorieOptional.isPresent()) {
                    sousCategorie = sousCategorieOptional.get();
                } else {
                    response.put("success", false);
                    response.put("message", "sousCategorie (SousCategorie) not found.");
                    return ResponseEntity.badRequest().body(response);
                }
            }

            // Business logic: You can process the directory addition here
            // e.g., save a new directory object based on the input values
            response.put("success", true);
            response.put("message", "Directory added successfully!");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Error occurred: " + e.getMessage());
            return ResponseEntity.status(500).body(response);
        }
    }
}