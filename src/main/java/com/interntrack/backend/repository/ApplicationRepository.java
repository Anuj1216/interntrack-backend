package com.interntrack.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.interntrack.backend.entity.Application;

public interface ApplicationRepository extends JpaRepository<Application, Long>{
	List<Application> findByEmail(String email);
	List<Application> findByStatus(String ststus);
	
	boolean existsByStudentIdAndInternshipId(
		Long studentId,
		Long internshipId
	);
	
	long count();
}
