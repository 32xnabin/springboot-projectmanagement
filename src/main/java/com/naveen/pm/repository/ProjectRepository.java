package com.naveen.pm.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naveen.pm.model.Project;


@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	 Project findById(long id);

	 void deleteById(long id);

}
