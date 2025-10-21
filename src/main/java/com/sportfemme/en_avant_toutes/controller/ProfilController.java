package com.sportfemme.en_avant_toutes.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
public class ProfilController {
    private final RoleService roleService;
    private VideoService videoService;
    private UserService userService;

    @Autowired
    public ProfilController(UserService userService, RoleService roleService, VideoService videoService) {
        this.roleService = roleService;
        this.videoService = videoService;
        this.userService = userService;
    }

    @GetMapping("/profil/{id}")
    public String getUserProfile(@PathVariable Long id, Model model, Principal principal) {
        if (principal == null) {
            throw new AccessDeniedException("You must be logged in to access this page.");
        }

        String loggedInUsername = principal.getName();
        User loggedInUser = userService.findByUsername(loggedInUsername);

        if (loggedInUser == null || !loggedInUser.getId().equals(id)) {
            throw new AccessDeniedException("You are not authorized to access this page.");
        }

        model.addAttribute("user", loggedInUser);
        model.addAttribute("videos", videoService.findByUserId(id));

        return "pages/profil";
    }

    @GetMapping("/profil/add_video")
    public String addVideoPage(HttpSession session, Model model, Principal
    principal) {
    if (principal == null) {
    return "redirect:/login";
    }
    
    String loggedInUsername = principal.getName();
    User user = userService.findByUsername(loggedInUsername);
    
    if (session.getAttribute("loggedInUser") == null) {
    session.setAttribute("loggedInUser", user);
    }
    
    model.addAttribute("user", user);
    return "pages/video";
    }
}


/*
 * 
 * 
 * 
 * 
 * 
 * public String addVideo(Model model, Principal principal) {
 * if (principal == null) {
 * throw new
 * AccessDeniedException("You must be logged in to access this page.");
 * }
 * 
 * String loggedInUsername = principal.getName();
 * User loggedInUser = userService.findByUsername(loggedInUsername);
 * 
 * model.addAttribute("user", loggedInUser);
 * 
 * return "pages/video";
 * }
 * }
 */
