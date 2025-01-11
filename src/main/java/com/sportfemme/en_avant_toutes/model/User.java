package com.sportfemme.en_avant_toutes.model;



import java.util.List;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    // @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Video> videos;

    @ManyToOne
    private Role role;

    /* 
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    */

   // @Column(columnDefinition = "BYTEA")
   // @Lob
  //  private byte[] avatar;

private boolean active= true;


}
