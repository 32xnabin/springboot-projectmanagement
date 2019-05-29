
package com.naveen.pm.service;

import java.util.List;

import com.naveen.pm.model.Comment;

public interface CommentService {

    public List<Comment> getCommentList();

    public Comment findCommentById(long id);

    public void save(Comment comment);

    public void edit(Comment comment);

    public void delete(long id);


}

