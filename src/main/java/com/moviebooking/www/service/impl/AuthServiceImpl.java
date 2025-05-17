package com.moviebooking.www.service.impl;

import com.moviebooking.www.dto.LoginResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.www.dto.LoginRequestDTO;
import com.moviebooking.www.dto.RegisterRequestDTO;
import com.moviebooking.www.entity.Users;
import com.moviebooking.www.repository.UsersRepository;
import com.moviebooking.www.service.AuthService;

import java.util.HashSet;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public Users registerUser(RegisterRequestDTO registerRequestDTO) {
        if (usersRepository.findByUsername(registerRequestDTO.getUsername()).isPresent() && usersRepository.findByEmail(registerRequestDTO.getEmail()).isPresent()) {

            throw new RuntimeException("User is Already Registered");
        }

        Set<String> roles = new HashSet<>();
        roles.add("USER");

        Users users = new Users();
        users.setUsername(registerRequestDTO.getUsername());
        users.setEmail(registerRequestDTO.getEmail());
        users.setPassword(registerRequestDTO.getPassword());
        users.setRoles(roles);

        return usersRepository.save(users);
    }


    @Override
    public Users registerAdmin(RegisterRequestDTO registerRequestDTO) {
        if (usersRepository.findByUsername(registerRequestDTO.getUsername()).isPresent() || usersRepository.findByEmail(registerRequestDTO.getEmail()).isPresent()) {
            throw new RuntimeException("User is Already Registered");
        }

        // Set the admin and User roles
        Set<String> roles = new HashSet<>();
        roles.add("USER");
        roles.add("ADMIN");

        Users users = new Users();
        users.setUsername(registerRequestDTO.getUsername());
        users.setEmail(registerRequestDTO.getEmail());
        users.setPassword(registerRequestDTO.getPassword());
        users.setRoles(roles);

        return usersRepository.save(users);
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO loginRequestDTO) {

        Users users = usersRepository.findByUsername(loginRequestDTO.getUsername())
                .orElseGet(() -> usersRepository.findByEmail(loginRequestDTO.getUsername())
                        .orElseThrow(() -> new RuntimeException("No user exists with this username/email: " + loginRequestDTO.getUsername())));

        if (!users.getPassword().equals(loginRequestDTO.getPassword())) {
            throw new RuntimeException("Password is Incorrect please try again");
        }

        LoginResponseDTO loginResponseDTO = new LoginResponseDTO();
        loginResponseDTO.setId((users.getId()));
        loginResponseDTO.setUsername(users.getUsername());
        loginResponseDTO.setRoles(users.getRoles());

        return loginResponseDTO;
    }
}
