package com.naveen.pm.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naveen.pm.model.Comment;


@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	
	    Comment findById(long id);

	    void deleteById(Long id);

}