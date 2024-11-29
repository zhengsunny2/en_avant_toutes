package com.sportfemme.en_avant_toutes.model;






import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String niveau;
    private String time;
    private String calories;
    private String titre;
    private String description;
    private String path;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sousCategorie_id")
    private SousCategorie sousCategorie;
    @ManyToOne
    private Utilisateur utilisateur;

    /* 


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categorie_id")
    private Categorie categorie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sous_categorie_id")
    private SousCategorie sousCategorie;
    */
}