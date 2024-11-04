package com.sportfemme.en_avant_toutes.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private String niveau;
    private String time;
    private String calories;
    private String titre;
    private String description;
    @ManyToOne
    private Utilisateur utilisateur;
    @ManyToOne
    private SousCategorie sousCategorie;
    @ManyToOne
    private Categorie categorie;
}
