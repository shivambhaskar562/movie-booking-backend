package com.moviebooking.www.controller;

import com.moviebooking.www.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.moviebooking.www.dto.RegisterRequestDTO;
import com.moviebooking.www.service.AuthService;

@RestController
//@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

	@Autowired
	private AuthService authService;

	@PostMapping("/register/admin")
	public ResponseEntity<Users> registerAdmin(@RequestBody RegisterRequestDTO registerRequestDTO) {
		return ResponseEntity.ok(authService.registerAdmin(registerRequestDTO));

	}

}
