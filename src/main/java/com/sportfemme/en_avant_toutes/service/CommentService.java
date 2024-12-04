package com.sportfemme.en_avant_toutes.service;

import java.util.List;

import com.sportfemme.en_avant_toutes.model.Comment;

public interface CommentService {
    
    public List<Comment> findAll();
    public Comment save(Comment comment);

    public void delete(Comment comment);

    public Comment findById(Long id);

    public Comment edit(Comment comment);
  
}
