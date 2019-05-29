package com.naveen.pm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.naveen.pm.model.Comment;
import com.naveen.pm.repository.CommentRepository;
import com.naveen.pm.service.CommentService;
@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentRepository CommentRepository;

    @Override
    public List<Comment> getCommentList() {
        return CommentRepository.findAll();
    }

    @Override
    public Comment findCommentById(long id) {
        return CommentRepository.findById(id);
    }

    @Override
    public void save(Comment comment) {
    	CommentRepository.save(comment);
    }

    @Override
    public void edit(Comment comment) {
    	CommentRepository.save(comment);
    }

    @Override
    public void delete(long id) {
    	CommentRepository.deleteById(id);
    }
}
