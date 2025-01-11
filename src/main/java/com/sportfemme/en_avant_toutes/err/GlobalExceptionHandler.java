package com.sportfemme.en_avant_toutes.err;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.ui.Model;

@RestController
public class GlobalExceptionHandler {
    //avec url = http://localhost:8000/bonjour
    //org.springframework.web.bind.MissingServletRequestParameterException
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.OK)
    public APIErrorMessage handleParameterNotFoundException(MissingServletRequestParameterException ex) {
        return new APIErrorMessage(404, "Exception levée - Vérifie le code ! ", ex.getMessage());
    }

    @ExceptionHandler(UserInexistantException.class)
    @ResponseStatus(HttpStatus.OK)
    public APIErrorMessage handleUserNotFoundException(UserInexistantException ex) {
        return new APIErrorMessage(404, "Pas d'user avec cet identifiant ", ex.getMessage());
    }

    @ExceptionHandler(UserInexistantException.class)
    @ResponseStatus(HttpStatus.OK)
    public APIErrorMessage handleUserAlreadyExistsException(UserInexistantException ex) {
        return new APIErrorMessage(404, "Un user existe deja avec cet identifiant ", ex.getMessage());
    }

    //avec url = http://localhost:8000/exception500
    //getmapping pour lever une exception
    @ExceptionHandler(value = { Exception.class })
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public APIErrorMessage unknownException(Exception ex) {
        ex.printStackTrace();
        return new APIErrorMessage(500, "Erreur interne du serveur", ex.getMessage());
    }

    @ExceptionHandler(AccessDeniedException.class)
    public String handleAccessDeniedException(AccessDeniedException ex, Model model) {
        model.addAttribute("error", "You are not authorized to access this page.");
        return "error/403"; // 403
    }

}



