package com.sportfemme.en_avant_toutes.controller;

    import java.util.List;
    
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportfemme.en_avant_toutes.model.Utilisateur;

    import com.sportfemme.en_avant_toutes.service.UtilisateurService;
    
    import io.swagger.v3.oas.annotations.parameters.RequestBody;
    
    @Controller
    public class UtilisateurController {
        private final UtilisateurService utilisateurService;
        public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
        }

    @GetMapping("/utilisateur_list")
    public String Utilisateur(Model model){
       List<Utilisateur> utilisateurs=utilisateurService.findAll();
       model.addAttribute("utilisateurs", utilisateurs);
        return "redirect:/admin";
    }
    
    @PostMapping("/utilisateur_add")
    public String save(@RequestBody Utilisateur utilisateur){
        utilisateur.setUsername(utilisateur.getUsername());
        utilisateur.setPassword(utilisateur.getPassword());
        utilisateurService.save(utilisateur);
        return "redirect:/profil";
    }
    
    @GetMapping("/utilisateur_profil")
    public  String findByUsernameAndPassword(@RequestParam String email, @RequestParam String password, Model model){
        Utilisateur utilisateur=utilisateurService.findByEmailAndPassword(email, password);
        if (utilisateur != null) {
            model.addAttribute("utilisateur", utilisateur);
            return "redirect:/profil";
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login"; 
        }
    }

}
    
