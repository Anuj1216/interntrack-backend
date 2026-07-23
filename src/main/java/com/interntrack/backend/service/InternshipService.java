package com.interntrack.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.interntrack.backend.entity.Internship;
import com.interntrack.backend.entity.User;
import com.interntrack.backend.repository.InternshipRepository;
import com.interntrack.backend.repository.UserRepository;

@Service
public class InternshipService {
	private final InternshipRepository internshipRepository;
	private final UserRepository userRepository;

	public InternshipService(InternshipRepository intershipRepository, UserRepository userRepository) {
		this.internshipRepository = intershipRepository;
		this.userRepository = userRepository;
	}
	
	public List<Internship> getAllInternship(){
		return internshipRepository.findAll();
	}
	
	public Internship getInternshipById(Long id) {
		return internshipRepository.findById(id).orElse(null);
	}
	
	public List<Internship> getInternshipByEmployer(Long employerId) {
		return internshipRepository.findByEmployerId(employerId);
	}
	
	public Internship createInternship(Long employerId, Internship internship) {
		User employer = userRepository.findById(employerId)
				.orElse(null);
		
		if(employer == null) {
			return null;
		}
		
		internship.setEmployer(employer);
		
		return internshipRepository.save(internship);
	}

	public Internship updateInternship(Long id, Internship updatedInternship) {
		Internship existingInternship = internshipRepository.findById(id).orElse(null);
		
		if(existingInternship == null) {
			return null;
		}
		
		existingInternship.setTitle(updatedInternship.getTitle());
		existingInternship.setCompany(updatedInternship.getCompany());
		existingInternship.setLocation(updatedInternship.getLocation());
		existingInternship.setDescription(updatedInternship.getDescription());
		existingInternship.setSkills(updatedInternship.getSkills());
		existingInternship.setStipend(updatedInternship.getStipend());
		
		return internshipRepository.save(existingInternship);
	}
	
	public void deleteInternship(Long id) {
		internshipRepository.deleteById(id);
	}
}
