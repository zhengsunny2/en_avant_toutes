package com.sportfemme.en_avant_toutes.model;



import com.fasterxml.jackson.annotation.JsonBackReference;


import jakarta.persistence.Entity;

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
public class SousCategorie {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    
    @ManyToOne
    @JsonBackReference 
    @JoinColumn(name = "categorie_id", nullable = false)
    private Categorie categorie;

/* 
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private SousCategorie parent;
*/

}

