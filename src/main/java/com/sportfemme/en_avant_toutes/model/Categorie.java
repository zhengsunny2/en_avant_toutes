package com.sportfemme.en_avant_toutes.model;






import com.sportfemme.en_avant_toutes.utils.enums.CategorieEnum;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
   @Enumerated(EnumType.STRING)
   @Column(unique = true, nullable = false)
   private CategorieEnum name;


/* 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Categorie parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Categorie> categories= new ArrayList<>();;

    @OneToMany(mappedBy = "categorie")
    private List<SousCategorie> sousCategories= new ArrayList<>();;

    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Video> videos = new ArrayList<>();
    */
}