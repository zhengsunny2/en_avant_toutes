package com.sportfemme.en_avant_toutes.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sportfemme.en_avant_toutes.model.Utilisateur;

import com.sportfemme.en_avant_toutes.repository.UtilisateurRepository;
import com.sportfemme.en_avant_toutes.service.UtilisateurService;
@Component
public class UtilisateurServiceImpl implements UtilisateurService {

   @Autowired
    private final UtilisateurRepository utilisateurRepository;
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

   @Override
   public Utilisateur save(Utilisateur utilisateur) {
       Utilisateur u = this.findByUsername(utilisateur.getUsername());
       if(u==null) {
           utilisateurRepository.save(utilisateur);
           return utilisateur;
       }

       return null;
   }
  
    @Override
    public Utilisateur edit(Utilisateur utilisateur) {
         if (utilisateur!=null) {
            Utilisateur u = findByEmail(utilisateur.getEmail());
             delete(u.getEmail());
             save(utilisateur);
             return utilisateur; 
         }
         return null;
     }
    @Override
    public List<Utilisateur> findAll() {
        return utilisateurRepository.findAll();
    
    }

    @Override
    public Utilisateur findByEmail(String email) {
        for(Utilisateur utilisateur:utilisateurRepository.findAll()){
            if (utilisateur.getEmail().equalsIgnoreCase(email)) {
                return utilisateur;
            }
        }
            return null;
    }
    @Override
    public Utilisateur findByUsername(String username) {
        for(Utilisateur utilisateur:utilisateurRepository.findAll()){
            if (utilisateur.getUsername().equalsIgnoreCase(username)) {
                return utilisateur;
            }
        }
            return null;
    }
 
    @Override
    public boolean active(String email) {
        Utilisateur utilisateur = this.findByEmail(email);
        if (utilisateur != null) { 
            utilisateur.setActive(!utilisateur.isActive()); 
        return true;  
    }
    return false;
}

    @Override
    public void delete(String email) {
        Utilisateur utilisateur = this.findByEmail(email);
        if (utilisateur != null) { 
            utilisateurRepository.delete(utilisateur);
        }
    }

    @Override
    public Utilisateur findByEmailAndPassword(String email,String password){
        for(Utilisateur utilisateur:utilisateurRepository.findAll()){
            if (utilisateur.getEmail().equalsIgnoreCase(email) && utilisateur.getPassword().equalsIgnoreCase(password)) {
                return utilisateur;
            }
        }
            return null;
    }
    }
    



