package com.naveen.pm.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naveen.pm.model.Task;


@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	 Task findById(long id);

	 void deleteById(Long id);

}
