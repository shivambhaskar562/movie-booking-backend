package com.moviebooking.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.www.dto.LoginRequestDTO;
import com.moviebooking.www.dto.LoginResponseDTO;
import com.moviebooking.www.dto.RegisterRequestDTO;
import com.moviebooking.www.entity.Users;
import com.moviebooking.www.repository.UsersRepositary;
import com.moviebooking.www.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	private UsersRepositary usersRepositary;

	@Override
	public Users registerUser(RegisterRequestDTO registerRequestDTO) {
		if (usersRepositary.findByUsername(registerRequestDTO.getUsername()).isPresent()
				|| usersRepositary.findByEmail(registerRequestDTO.getEmail()).isPresent()) {
			throw new RuntimeException("User is Already Registered");
		}

		// Set the admin and User role

		Users users = new Users();
		users.setUsername(registerRequestDTO.getUsername());
		users.setEmail(registerRequestDTO.getEmail());
		users.setPassword(registerRequestDTO.getPassword());
		return usersRepositary.save(users);
	}

	/**
	 * 
	 */
	@Override
	public Users registerAdmin(RegisterRequestDTO registerRequestDTO) {
		if (usersRepositary.findByUsername(registerRequestDTO.getUsername()).isPresent()
				|| usersRepositary.findByEmail(registerRequestDTO.getEmail()).isPresent()) {
			throw new RuntimeException("User is Already Registered");
		}

		// Set the admin and User role

		Users users = new Users();
		users.setUsername(registerRequestDTO.getUsername());
		users.setEmail(registerRequestDTO.getEmail());
		users.setPassword(registerRequestDTO.getPassword());
		return usersRepositary.save(users);
	}
	
	@Override
	public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {
		return null;
	}

}
