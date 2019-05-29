package com.naveen.pm.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.naveen.pm.ResourceNotFoundException;
import com.naveen.pm.model.Comment;
import com.naveen.pm.repository.CommentRepository;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CommentRestController {

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/comments")
    public List<Comment> getAllcomments() {
        return commentRepository.findAll();
    }

    @PostMapping("/comments")
    public Comment createcomment(@Valid @RequestBody Comment comment) {
        return commentRepository.save(comment);
    }

    @GetMapping("/comments/{id}")
    public Comment getcommentById(@PathVariable(value = "id") Long commentId) {
        return commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("comment", "id", commentId));
    }

    @PutMapping("/comments/{id}")
    public Comment updatecomment(@PathVariable(value = "id") Long commentId,
                                           @Valid @RequestBody Comment commentDetails) {

    	Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("comment", "id", commentId));

        comment.setContent(commentDetails.getContent());
       // comment.setTask(commentDetails.getTask());

        Comment updatedcomment = commentRepository.save(comment);
        return updatedcomment;
    }

    @DeleteMapping("/comments/{id}")
    public ResponseEntity<?> deletecomment(@PathVariable(value = "id") Long commentId) {
    	Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("comment", "id", commentId));

        commentRepository.delete(comment);

        return ResponseEntity.ok().build(); 
    }
}

