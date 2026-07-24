package com.interntrack.backend.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.interntrack.backend.entity.Application;
import com.interntrack.backend.entity.Internship;
import com.interntrack.backend.entity.User;
import com.interntrack.backend.enums.ApplicationStatus;
import com.interntrack.backend.repository.ApplicationRepository;
import com.interntrack.backend.repository.InternshipRepository;
import com.interntrack.backend.repository.UserRepository;

@Service
public class ApplicationService {
	private final ApplicationRepository applicationRepository;
	private final InternshipRepository internshipRepository;
	private final UserRepository userRepository;
	
	public ApplicationService(ApplicationRepository applicationRepository, InternshipRepository internshipRepository, UserRepository userRepository) {
		this.applicationRepository = applicationRepository;
		this.internshipRepository = internshipRepository;
		this.userRepository = userRepository;
	}
	
	public Application applyForInternship(
			Long internshipId,
			Long studentId,
			Application application) {
		
		if(applicationRepository.existsByStudentIdAndInternshipId(studentId, internshipId)) {
			return null;
		}
		
		Internship internship = internshipRepository.findById(internshipId).orElse(null);
		
		User student = userRepository.findById(studentId).orElse(null);
		
		if(internship == null || student == null) {
			return null;
		}
		
		application.setInternship(internship);
		application.setStatus(ApplicationStatus.PENDING);
		application.setStudent(student);
		application.setAppliedDate(LocalDate.now());
		return applicationRepository.save(application);
	}
	
	public List<Application> getAllApplications(){
		return applicationRepository.findAll();
	}
	
//	public List<Application> getApplicationsByEmail(String email){
//		return applicationRepository.findByEmail(email);
//	}
	
	public List<Application> getApplicationsByStudent(Long studentId){
		return applicationRepository.findByStudentId(studentId);
	}
	
	public List<Application> getApplicationsByEmployer(Long employerId){
		return applicationRepository.findByInternshipEmployerId(employerId);
	}
	
	public Application updateStatus(Long id, ApplicationStatus status) {
		Application application = applicationRepository.findById(id).orElse(null);
		
		if(application == null) {
			return null;
		}
		
		application.setStatus(status);
		
		return applicationRepository.save(application);
	}
	
	public long getApplicationCount() {

	    return applicationRepository.count();

	}
	
}


