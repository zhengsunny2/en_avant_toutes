package com.sportfemme.en_avant_toutes.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sportfemme.en_avant_toutes.model.Utilisateur;
@Service
public interface UtilisateurService {
    public Utilisateur save(Utilisateur utilisateur);
    public Utilisateur edit(Utilisateur utilisateur);
    public List<Utilisateur> findAll();
    public Utilisateur findByEmail(String email);
    public boolean active(String email);
    public void delete(String email);

}
