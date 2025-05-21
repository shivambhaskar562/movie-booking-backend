package com.moviebooking.www.controller;

import com.moviebooking.www.dto.UsersDTO;
import com.moviebooking.www.entity.Users;
import com.moviebooking.www.response.ResponseStructure;
import com.moviebooking.www.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UsersService userService;

    @GetMapping("/profile/{username}")
    public ResponseEntity<ResponseStructure<Users>> findUsersProfile(@PathVariable String username) {
        Users users = userService.UserProfile(username);

        ResponseStructure<Users> responseStructure = new ResponseStructure<>();
        responseStructure.setStatus("Success");
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("User profile fetched successfully");
        responseStructure.setDateTime(LocalDateTime.now());
        responseStructure.setData(users);

        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    @PutMapping("/profile/{username}")
    public ResponseEntity<ResponseStructure<Users>> updateUsersProfile(
            @PathVariable String username, @RequestBody UsersDTO usersDTO) {

        Users users = userService.updateUserProfile(username, usersDTO);

        ResponseStructure<Users> responseStructure = new ResponseStructure<>();
        responseStructure.setStatus("Success");
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("User profile updated successfully");
        responseStructure.setDateTime(LocalDateTime.now());
        responseStructure.setData(users);

        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }
}