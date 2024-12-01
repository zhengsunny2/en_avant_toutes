package com.sportfemme.en_avant_toutes.model;






import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Categorie  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   @OneToMany(mappedBy = "categorie")
   @JsonManagedReference
   private List<SousCategorie> sousCategories= new ArrayList<>();;

   @OneToMany(mappedBy = "categorie")
   private List<Video> videos = new ArrayList<>();
   


   /* 
   @Enumerated(EnumType.STRING)
   @Column(unique = true, nullable = false)
   private CategorieEnum name;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Categorie parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Categorie> categories= new ArrayList<>();;

    */
}