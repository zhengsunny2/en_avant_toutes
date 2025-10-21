package com.sportfemme.en_avant_toutes.model;




import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
// @Builder @Table(name = "Utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;
    private String username;
    private String password;
    private String firstname;
    private String lastname;
    private String email;
    private int phone;
    private String city;
    private String birthday;
    private String biographie;
    private boolean active;
    @ManyToOne
    private Role role;
    @OneToMany(mappedBy = "utilisateur")
    private List<Comment> comments;
    @OneToMany(mappedBy = "utilisateur")
    private List<Favorite> favorites;
    @OneToMany(mappedBy = "utilisateur")
    private List<Video> videos;

}

