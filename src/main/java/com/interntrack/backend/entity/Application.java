package com.interntrack.backend.entity;
import com.interntrack.backend.enums.ApplicationStatus;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "applications")
public class Application {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String applicantName;
	private String email;
	
	
	@Enumerated(EnumType.STRING)
	private ApplicationStatus status;
	
	
	private LocalDate appliedDate;
	
	@ManyToOne
	@JoinColumn(name = "internship_id")
	private Internship internship;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private User student;

	public Application() {
	}

	

	public Application(Long id, String applicantName, String email, ApplicationStatus status, LocalDate appliedDate,
			Internship internship, User student) {
		super();
		this.id = id;
		this.status = status;
		this.appliedDate = appliedDate;
		this.internship = internship;
		this.student = student;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApplicantName() {
		return applicantName;
	}

	public void setApplicantName(String applicantName) {
		this.applicantName = applicantName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public ApplicationStatus getStatus() {
		return status;
	}

	public void setStatus(ApplicationStatus status) {
		this.status = status;
	}

	public LocalDate getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(LocalDate appliedDate) {
		this.appliedDate = appliedDate;
	}

	public Internship getInternship() {
		return internship;
	}

	public void setInternship(Internship internship) {
		this.internship = internship;
	}

	public User getStudent() {
		return student;
	}

	public void setStudent(User student) {
		this.student = student;
	}
	
	
	
}
