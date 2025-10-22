package com.sportfemme.en_avant_toutes.config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.sportfemme.en_avant_toutes.model.User;
import com.sportfemme.en_avant_toutes.service.UserService;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Lazy
    @Autowired
    private UserService userService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        HttpSession session = request.getSession();

        
        session.setAttribute("username", authentication.getName());
        session.setAttribute("role", authentication.getAuthorities());

        
        User user = userService.findByUsername(authentication.getName());
        if (user != null) {
            session.setAttribute("userId", user.getId());
        }

        
        boolean isAdmin = authentication.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_ADMIN"));
        boolean isUser = authentication.getAuthorities().stream()
                .anyMatch(role -> role.getAuthority().equals("ROLE_USER"));

        if (isAdmin) {
            response.sendRedirect("/admin");
        } else if (isUser && user != null) {
            response.sendRedirect("/profil/" + user.getId());
        } else {
            
            response.sendRedirect("/inscription");
        }
    }
}