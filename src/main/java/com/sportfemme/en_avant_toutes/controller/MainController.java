package com.sportfemme.en_avant_toutes.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.sportfemme.en_avant_toutes.model.Role;

import com.sportfemme.en_avant_toutes.service.RoleService;



@Controller
public class MainController {
    private final RoleService roleService;
    public MainController(RoleService roleService) {
    this.roleService = roleService;
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }



     @GetMapping("/contact")
    public String contact(){
        return "pages/contact";
    }


    @GetMapping("/admin")
    public String admin(){
        return "pages/admin";
    }

    @GetMapping("/profil")
    public String profil(){
        return "pages/profil";
    }
    @GetMapping("/categorie")
    public String categorie() {
        return "pages/categorie";
    }

    @GetMapping("/video")
    public String video() {
        return "pages/video";
    }

    @GetMapping("/inscription")
    public String inscription(){
        return "pages/inscription";
    }
    
/* 
    @GetMapping("/inscription")
    public String inscription(){
        return "pages/inscription";
    }
*/
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

}
