package com.interntrack.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import com.interntrack.backend.entity.Application;
import com.interntrack.backend.service.ApplicationService;
import com.interntrack.backend.enums.ApplicationStatus;

@RestController
@RequestMapping("/api/applications")
@CrossOrigin(origins = "*")
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/internship/{internshipId}/student/{studentId}")
    public ResponseEntity<?> applyForInternship(
            @PathVariable Long internshipId,
            @PathVariable Long studentId,
            @RequestBody Application application) {

        Application result = applicationService.applyForInternship(
                internshipId,
                studentId,
                application);
        
        if(result == null) {
        	return ResponseEntity.badRequest().body("You have already applied for this internship ot it doesn't exist.");
        }
        
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public List<Application> getAllApplications() {
        return applicationService.getAllApplications();
    }

    @GetMapping("/email/{email}")
    public List<Application> getApplicationsByEmail(
            @PathVariable String email) {

        return applicationService
                .getApplicationsByEmail(email);
    }
    
    @GetMapping("/student/{studentId}")
    public List<Application> getApplicationsByStudent(@PathVariable Long studentId){
    	return applicationService.getApplicationsByStudent(studentId);
    }
    
    @GetMapping("/employer/{employerId}")
    public List<Application> getApplicationsByEmployer(@PathVariable Long employerId){
    	return applicationService.getApplicationsByEmployer(employerId);
    }

    @PutMapping("/{id}/status")
    public Application updateStatus(
            @PathVariable Long id,
            @RequestParam ApplicationStatus status) {

        return applicationService.updateStatus(id, status);
    }
    
    @GetMapping("/count")
    public long getApplicationCount() {

        return applicationService
                .getApplicationCount();

    }
}