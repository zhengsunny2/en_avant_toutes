package com.sportfemme.en_avant_toutes.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.sportfemme.en_avant_toutes.model.Role;
import com.sportfemme.en_avant_toutes.model.Utilisateur;
import com.sportfemme.en_avant_toutes.service.RoleService;
import com.sportfemme.en_avant_toutes.service.UtilisateurService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Controller
public class MainController {
    private final RoleService roleService;
    private final UtilisateurService utilisateurService;
    public MainController(RoleService roleService,UtilisateurService utilisateurService) {
    this.roleService = roleService;
    this.utilisateurService = utilisateurService;
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }
     @GetMapping("/contact")
    public String contact(){
        return "pages/contact";
    }
       @GetMapping("/inscription")
    public String inscription(){
        return "pages/inscription";
    }

    @GetMapping("/admin")
    public String admin(){
        return "pages/admin";
    }

    @GetMapping("/role_list")
    public String role(Model model){
       List<Role> roles=roleService.findAll();
       model.addAttribute("roles", roles);
        return "pages/role";
    }

    @PostMapping("/role_add")
    public String AddRole(@RequestParam("name") String name){
        System.out.println("name:"+name);
        Role role=new Role();
        role.setName(name);
        roleService.save(role);
        return "redirect:/role_list";
    }

    @GetMapping("/utilisateur_list")
    public String utilisateur(Model model){
       List<Utilisateur> utilisateurs=utilisateurService.findAll();
       model.addAttribute("utilisateurs", utilisateurs);
        return "pages/admin";
    }

    @PostMapping("/utilisateur_add")
    public String save(@RequestBody Utilisateur utilisateur){
        utilisateur.setEmail(utilisateur.getEmail());
        utilisateur.setPassword(utilisateur.getPassword());
        utilisateurService.save(utilisateur);
        return "index";
    }
    @GetMapping("/utilisateur")
    public String findByEmail(@RequestBody Utilisateur utilisateur){
        utilisateur=utilisateurService.findByEmail(utilisateur.getEmail());
        return "index";
    }
}

