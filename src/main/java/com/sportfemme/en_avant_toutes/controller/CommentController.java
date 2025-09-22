package com.sportfemme.en_avant_toutes.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.sportfemme.en_avant_toutes.model.Comment;
import com.sportfemme.en_avant_toutes.service.CommentService;

@Controller
public class CommentController {

    private final CommentService commentService;
    
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

 
    @GetMapping("/comments")
    public String comment(Model model){
       List<Comment> comments=commentService.findAll();
       model.addAttribute("comments", comments);
        return "fiche_video";
    }


  /*
    @PostMapping("/add_comment")
    public String addComment(@RequestParam("content") String content, 
                             @RequestParam("utilisateur") Utilisateur utilisateur) {
        Comment comment = new Comment();
        comment.setContent(content);
        
        comment.setUtilisateur(utilisateur);
        commentService.save(comment);
        return "fiche_video";
    }
   */
    
    @PostMapping
    public Comment addComment(@RequestBody Comment comment) {
        comment.setDate(LocalDateTime.now());
		return commentService.save(comment);
    }
    
    
    @PostMapping("/comments")
    public Comment saveComment(@RequestBody Comment comment) {
        return commentService.save(comment);
    }
    
    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable Long id, @RequestBody Comment updatedComment) {
        updatedComment.setId(id);
        return commentService.edit(updatedComment);
    }
    
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable Long id) {
        Comment commentToDelete = commentService.findById(id);
        if (commentToDelete != null) {
            commentService.delete(commentToDelete);
        }
        }
    
}

