package com.interntrack.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.interntrack.backend.entity.Internship;
import com.interntrack.backend.service.InternshipService;

@RestController
@RequestMapping("/api/internships")
@CrossOrigin(origins = "*")
public class InternshipController {
	private final InternshipService internshipService;

	public InternshipController(InternshipService internshipService) {
		this.internshipService = internshipService;
	}
	
	@GetMapping
	public List<Internship> getAllInternship(){
		return internshipService.getAllInternship();
	}
	
	@GetMapping("/{id}")
	public Internship getInternshipById(@PathVariable Long id) {
		return internshipService.getInternshipById(id);
	}
	
	@GetMapping("/employer/{employerId}")
	public List<Internship> getInternshipByEmployer(@PathVariable Long employerId) {
		return internshipService.getInternshipByEmployer(employerId);
	}
	
	@PostMapping
	public Internship createInternship(
			@RequestParam Long employerId,
			@RequestBody Internship internship) {
		return internshipService.createInternship(employerId, internship);
	}
	
	@PutMapping("/{id}")
	public Internship updateInternship(
			@PathVariable Long id,
			@RequestBody Internship internship) {
		return internshipService.updateInternship(id, internship);
	}
	
	@DeleteMapping("/{id}")
	public void deleteInternship(@PathVariable Long id) {
		internshipService.deleteInternship(id);
	}
	
	@GetMapping("/count")
	public long getInternshipCount() {

	    return internshipService
	            .getAllInternship()
	            .size();

	}
	
}
