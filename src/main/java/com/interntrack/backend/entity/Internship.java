package com.interntrack.backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "internships")
public class Internship {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String title;
	private String company;
	private String location;
	private String description;
	private String skills;
	private String stipend;
	
	
	
	
	public Internship() {
		super();
	}

	public Internship(Long id, String title, String company, String location, String description, String skills,
			String stipend) {
		super();
		this.id = id;
		this.title = title;
		this.company = company;
		this.location = location;
		this.description = description;
		this.skills = skills;
		this.stipend = stipend;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getStipend() {
		return stipend;
	}

	public void setStipend(String stipend) {
		this.stipend = stipend;
	}
	
	
}
