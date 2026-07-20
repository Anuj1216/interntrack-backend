package com.interntrack.backend.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.interntrack.backend.entity.User;
import com.interntrack.backend.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User registerUser(User user) {
		if(userRepository.existsByEmail(user.getEmail())) {
			return null;
		}
		
		if(user.getRole() == null || user.getRole().isBlank()) {
			user.setRole("STUDENT");
		}
		
		String encodedPassword = passwordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		
		return userRepository.save(user);
	}
	
	public User loginUser(String email, String password) {
		
		User user = userRepository.findByEmail(email).orElse(null);
		
		if(user == null) {
			return null;
		}
		
		if(!passwordEncoder.matches(password, user.getPassword())) {
			return null;
		}
		
		return user;
	}
	
}
