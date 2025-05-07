package com.moviebooking.www.controller;

import com.moviebooking.www.dto.LoginResponseDTO;
import com.moviebooking.www.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.moviebooking.www.dto.LoginRequestDTO;
import com.moviebooking.www.dto.RegisterRequestDTO;
import com.moviebooking.www.service.AuthService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register/user")
    public ResponseEntity<Users> registerUser(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) {
        return ResponseEntity.ok(authService.registerUser(registerRequestDTO));
    }

    @PostMapping("/register/admin")
    public ResponseEntity<Users> registerAdmin(@RequestBody @Valid RegisterRequestDTO registerRequestDTO) {
        return ResponseEntity.ok(authService.registerAdmin(registerRequestDTO));
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO loginRequestDTO) {
        return ResponseEntity.ok(authService.login(loginRequestDTO));
    }
}
