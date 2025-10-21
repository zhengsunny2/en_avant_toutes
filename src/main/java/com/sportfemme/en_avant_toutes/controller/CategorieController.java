package com.sportfemme.en_avant_toutes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.sportfemme.en_avant_toutes.model.Categorie;
import com.sportfemme.en_avant_toutes.model.SousCategorie;
import com.sportfemme.en_avant_toutes.service.CategorieService;
import com.sportfemme.en_avant_toutes.service.SousCategorieService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/categories")
public class CategorieController {
 @Autowired
    private final CategorieService categorieService;
    private final SousCategorieService sousCategorieService;

    public CategorieController(CategorieService categorieService,SousCategorieService sousCategorieService) {
        this.categorieService = categorieService;
        this.sousCategorieService=sousCategorieService;
    }

    @GetMapping
    public ResponseEntity<List<Categorie>> findAllCategorie() {
        List<Categorie> categories = categorieService.findAll();
        return ResponseEntity.ok(categories);
    }

    @PostMapping("/ajouter-categorie")

public ResponseEntity<Map<String, Object>> addCategorie(@RequestBody Map<String, String> request) {
    Map<String, Object> response = new HashMap<>();
    try {
        String name = request.get("name");
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Categorie name is required.");
        }
        Categorie newCategorie = categorieService.addCategorie(name);
        response.put("success", true);
        response.put("message", "Categorie added successfully.");
        return ResponseEntity.ok(response);
    } catch (Exception e) {
        response.put("success", false);
        response.put("message", "Error adding Categorie: " + e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}


    @PostMapping("/{categorieId}/add-sousCategorie")

    public ResponseEntity<Map<String, Object>> addSousCategorie(@PathVariable Long categorieId, @RequestBody Map<String, String> request) {
        Map<String, Object> response = new HashMap<>();
        try {
            String name = request.get("name");
            if (name == null || name.isEmpty()) {
                throw new IllegalArgumentException("SousCategorie name is required.");
            }
            SousCategorie newSousCategorie = sousCategorieService.addSousCategorie(categorieId, name);
            response.put("success", true);
            response.put("message", "SousCategorie added successfully.");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Error adding SousCategorie: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }
    
   
    @GetMapping("/{categorieId}/sousCategories")
    public ResponseEntity<List<SousCategorie>> findAllSousCategorie(@PathVariable Long categorieId)  {
        List<SousCategorie> sousCategories = sousCategorieService.findByCategorieId(categorieId);
        return ResponseEntity.ok(sousCategories);
    }

}

  /* 

  

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.sportfemme.en_avant_toutes.model.Categorie;
import com.sportfemme.en_avant_toutes.model.SousCategorie;
import com.sportfemme.en_avant_toutes.service.CategorieService;
import com.sportfemme.en_avant_toutes.service.SousCategorieService;
import com.sportfemme.en_avant_toutes.utils.enums.CategorieEnum;



@Controller
public class CategorieController {

    private final CategorieService categorieService;


    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService; 
    }

    @GetMapping("/categorie")
    public String categorie() {
        return "pages/categorie";
    }


    @PostMapping("/add-category")
public ResponseEntity<Map<String, Object>> addCategory(@RequestParam String name) {
        // Create new category
        Categorie categorie = new Categorie();
        categorie.setName(CategorieEnum.fromString(name));
        categorieService.save(categorie);
        
        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        return ResponseEntity.ok(response);
    }


    @RequestMapping("/categories/{name}")
    public ResponseEntity<Optional<Categorie>> getCategories(@RequestParam(required = false) CategorieEnum name) {
      return ResponseEntity.ok(categorieService.findByName(name));
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Categorie>> getCategories() {
        return ResponseEntity.ok(categorieService.findAll());
    }



    @PostMapping("/add-sous-category")
    public ResponseEntity<Map<String, Object>> addSousCategory(@RequestBody SousCategorie sousCategorie) {

      sousCategorieService.save(sousCategorie);
      Map<String, Object> response = new HashMap<>();
      response.put("success", true);
      return ResponseEntity.ok(response);
    }
    
     @PostMapping("/{categorieId}/add-sousCategorie")
        public ResponseEntity<SousCategorie> addSousCategorie(@PathVariable Long categorieId, @RequestBody SousCategorie sousCategorie) {
            Categorie categorie = categorieService.findById(categorieId);
            if (categorie != null) {
                sousCategorie.setCategorie(categorie);
                SousCategorie savedsousCategorie = sousCategorieService.save(sousCategorie);
                return ResponseEntity.ok(savedsousCategorie);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }

        @GetMapping("/categorie")
    public String categorie() {
        return "pages/categorie";
    }

      @GetMapping("/categories")
    public List<Categorie> getCategories() {
        return categorieService.findAll();
    }
    @RequestMapping("/categories/{type}")
    public ResponseEntity<List<Categorie>> getCategories(@RequestParam(required = false) CategorieEnum type) {
        List<Categorie> categories;
        
        // If the 'type' parameter is not provided, find all categories.
        if (type != null) {
            categories = categorieService.findByType(type);
        } else {
            categories = categorieService.findAll(); // Assuming a method for all categories.
        }
        
        return ResponseEntity.ok(categories);
    }
    





    @GetMapping("/categorie/{name}")
public ResponseEntity<Categorie> getCategorie(@PathVariable String name) {
    return categorieService.findByName(name)
    .map(categorie -> {
    
        Hibernate.initialize(categorie.getSousCategories());
        return ResponseEntity.ok(categorie);
    })
    .orElseThrow(() -> new ResourceNotFoundException("Categorie not found with name " + name));
}


@RequestMapping("/categories/ENTRAINEMENT/{id}")
public ResponseEntity<Categorie> getCategoryById(@PathVariable Long id) {
    return categorieService.findById(id)
        .map(categorie -> {
        
            Hibernate.initialize(categorie.getSousCategories());
            return ResponseEntity.ok(categorie);
        })
        .orElseThrow(() -> new ResourceNotFoundException("Categorie not found with id " + id));
}



@PostMapping("/add-category")
public ResponseEntity<Map<String, Object>> addCategory(@RequestParam String name, 
                                                       @RequestParam CategorieEnum type, 
                                                       @RequestParam(required = false) Long parent) {
    // Create new category
    Categorie categorie = new Categorie();
    categorie.setName(name);
    categorie.setType(type);

    if (parent != null) {
        // If a parent directory is selected, set it
        Optional<Categorie> parentCategory = categorieService.findById(parent);
        parentCategory.ifPresent(categorie::setParent);  // Set the parent if it exists
    }

    categorieService.save(categorie);
    
    Map<String, Object> response = new HashMap<>();
    response.put("success", true);
    return ResponseEntity.ok(response);
}

 @PostMapping("/{categorieId}/add-sousCategorie")
    public ResponseEntity<SousCategorie> addSousCategorie(@PathVariable Long categorieId, @RequestBody SousCategorie sousCategorie) {
        Categorie categorie = categorieService.getById(categorieId);
        if (categorie != null) {
            sousCategorie.setCategorie(categorie);
            SousCategorie savedsousCategorie = sousCategorieService.save(sousCategorie);
            return ResponseEntity.ok(savedsousCategorie);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}

*/


