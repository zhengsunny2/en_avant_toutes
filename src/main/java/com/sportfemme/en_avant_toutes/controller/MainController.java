package com.sportfemme.en_avant_toutes.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.sportfemme.en_avant_toutes.dto.UserLoginDTO;
import com.sportfemme.en_avant_toutes.model.Role;
import com.sportfemme.en_avant_toutes.model.User;
import com.sportfemme.en_avant_toutes.model.Video;
import com.sportfemme.en_avant_toutes.service.RoleService;
import com.sportfemme.en_avant_toutes.service.UserService;
import com.sportfemme.en_avant_toutes.service.VideoService;

import jakarta.servlet.http.HttpSession;



@Controller
public class MainController {
    private final RoleService roleService;
    private VideoService videoService;
    private  UserService userService;

    public MainController(UserService userService,RoleService roleService,VideoService videoService) {
    this.roleService = roleService;
    this.videoService=videoService;
    this.userService=userService;
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
public String video(HttpSession session, Model model) {
    UserLoginDTO loggedInUserDTO = (UserLoginDTO) session.getAttribute("loggedInUser");
    if (loggedInUserDTO != null) {
        User loggedInUser = userService.findByUsernameAndPassword(
        loggedInUserDTO.getUsername(),
        loggedInUserDTO.getPassword()
        );
        model.addAttribute("loggedInUser", loggedInUser);
        return "pages/video";
    } else {
        return "redirect:/inscription";
    }
}


    @GetMapping("videos/video/{videoId}")
public String videoDetail(@PathVariable Long videoId, Model model) {
    Video video = videoService.findById(videoId);
    if (video != null) {
        model.addAttribute("video", video);
        model.addAttribute("videoPageUrl", video.getPath());
        return "pages/videoDetail";
    } else {
        return "/index";
    }
}
    /* 
    @GetMapping("videos/video/{id}")
    public String videoDetail() {
        return "pages/videoDetail";
    }
        */

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
