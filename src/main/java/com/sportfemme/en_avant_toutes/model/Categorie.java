package com.sportfemme.en_avant_toutes.model;





import java.util.List;

import com.sportfemme.en_avant_toutes.utils.enums.CategorieEnum;

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
    private long id;
    private CategorieEnum nom;
    @OneToMany(mappedBy = "categorie")
    private List<Video> videos;
}
