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
public class Favorite{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private long id;
    @ManyToOne
    private Utilisateur utilisateur;

    @ManyToOne
    private Video video;

}
