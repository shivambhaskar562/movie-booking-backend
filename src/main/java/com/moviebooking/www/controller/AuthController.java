package com.moviebooking.www.controller;

import com.moviebooking.www.dto.LoginResponseDTO;
import com.moviebooking.www.entity.Users;
import com.moviebooking.www.response.ResponseStructure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.moviebooking.www.dto.LoginRequestDTO;
import com.moviebooking.www.dto.RegisterRequestDTO;
import com.moviebooking.www.service.AuthService;

import jakarta.validation.Valid;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
//@CrossOrigin(origins = "http://127.0.0.
@CrossOrigin(origins = { "http://localhost:3000",
		"http://127.0.0.1:3000" }, allowedHeaders = "*", allowCredentials = "true")
public class AuthController {

	@Autowired
	private AuthService authService;

	@PostMapping("/register/user")
	public ResponseEntity<ResponseStructure<Users>> registerUser(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) {
		ResponseStructure<Users> responseStructure = new ResponseStructure<>();
		Users users = authService.registerUser(registerRequestDTO);

		responseStructure.setStatus("Success");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("User successfully registered.");
		responseStructure.setDateTime(LocalDateTime.now());
		responseStructure.setData(users);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@PostMapping("/register/admin")
	public ResponseEntity<ResponseStructure<Users>> registerAdmin(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) {
		ResponseStructure<Users> responseStructure = new ResponseStructure<>();
		Users users = authService.registerAdmin(registerRequestDTO);

		responseStructure.setStatus("Success");
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Admin successfully registered.");
		responseStructure.setDateTime(LocalDateTime.now());
		responseStructure.setData(users);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@PostMapping("/login")
	public ResponseEntity<ResponseStructure<LoginResponseDTO>> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
		ResponseStructure<LoginResponseDTO> responseStructure = new ResponseStructure<>();
		LoginResponseDTO loginResponse = authService.login(loginRequestDTO);

		responseStructure.setStatus("Success");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Login Successful");
		responseStructure.setDateTime(LocalDateTime.now());
		responseStructure.setData(loginResponse);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}
}
