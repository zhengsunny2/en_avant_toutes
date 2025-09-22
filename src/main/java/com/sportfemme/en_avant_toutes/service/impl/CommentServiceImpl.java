package com.sportfemme.en_avant_toutes.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sportfemme.en_avant_toutes.model.Comment;
import com.sportfemme.en_avant_toutes.repository.CommentRepository;
import com.sportfemme.en_avant_toutes.service.CommentService;

@Component
public class CommentServiceImpl implements CommentService {
   
    private final CommentRepository commentRepository;
    
    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
    
    @Override
    public void delete(Comment comment) {
        commentRepository.delete(comment);
    }

    @Override
    public Comment findById(Long id) {
    	Optional<Comment> optionalComment = commentRepository.findById(id);
    	 return optionalComment.orElse(null);
    }

    @Override
    public Comment edit(Comment comment) {
        return commentRepository.save(comment);
    }
    
  
}
