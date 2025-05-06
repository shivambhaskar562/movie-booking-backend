package com.moviebooking.www.service;

import com.moviebooking.www.dto.LoginRequestDTO;
import com.moviebooking.www.dto.RegisterRequestDTO;
import com.moviebooking.www.dto.LoginResponseDTO;
import com.moviebooking.www.entity.Users;

public interface AuthService{
	
	Users registerUser(RegisterRequestDTO registerRequestDTO);
	Users registerAdmin(RegisterRequestDTO registerRequestDTO);
	LoginResponseDTO login(LoginRequestDTO loginRequestDTO);
}
