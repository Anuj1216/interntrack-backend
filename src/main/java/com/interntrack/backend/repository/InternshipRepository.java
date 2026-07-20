package com.interntrack.backend.repository;

import com.interntrack.backend.entity.Internship;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InternshipRepository extends JpaRepository<Internship, Long>{
	
}
