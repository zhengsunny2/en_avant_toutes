package com.sportfemme.en_avant_toutes.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sportfemme.en_avant_toutes.model.Utilisateur;

import com.sportfemme.en_avant_toutes.repository.UtilisateurRepository;
@Component
public class UtilisateurServiceImpl implements UtilisateurService {

   @Autowired
    private final UtilisateurRepository utilisateurRepository;
    public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

   @Override
   public Utilisateur save(Utilisateur utilisateur) {
       Utilisateur u = this.findByEmail(utilisateur.getEmail());
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
    }



