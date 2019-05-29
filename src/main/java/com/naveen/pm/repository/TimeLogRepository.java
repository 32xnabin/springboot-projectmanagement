package com.naveen.pm.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.naveen.pm.model.TimeLog;


@Repository
public interface TimeLogRepository extends JpaRepository<TimeLog, Long> {
	
	    TimeLog findById(long id);

	    void deleteById(Long id);

}