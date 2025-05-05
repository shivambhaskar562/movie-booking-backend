package com.moviebooking.www.controller;

import com.moviebooking.www.dto.LoginResponseDTO;
import com.moviebooking.www.entity.Users;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.www.dto.LoginRequestDTO;
import com.moviebooking.www.dto.RegisterRequestDTO;
import com.moviebooking.www.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/register/user")
	public ResponseEntity<Users> registerUser(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) {
		return ResponseEntity.ok(authService.registerUser(registerRequestDTO));
	}

	@PostMapping
	public ResponseEntity<LoginResponseDTO> login(@RequestBody LoginRequestDTO loginRequestDTO) {
		return ResponseEntity.ok(authService.login(loginRequestDTO));
	}
}
