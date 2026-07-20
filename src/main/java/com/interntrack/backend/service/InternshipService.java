package com.interntrack.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.interntrack.backend.entity.Internship;
import com.interntrack.backend.repository.InternshipRepository;

@Service
public class InternshipService {
	private final InternshipRepository internshipRepository;

	public InternshipService(InternshipRepository intershipRepository) {
		this.internshipRepository = intershipRepository;
	}
	
	public List<Internship> getAllInternship(){
		return internshipRepository.findAll();
	}
	
	public Internship getInternshipById(Long id) {
		return internshipRepository.findById(id).orElse(null);
	}
	
	public Internship createInternship(Internship internship) {
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
