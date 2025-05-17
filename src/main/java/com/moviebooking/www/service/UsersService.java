package com.moviebooking.www.service;

import com.moviebooking.www.dto.UsersDTO;
import com.moviebooking.www.entity.Users;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersService {
    Users UserProfile(String username);
    Users updateUserProfile(String username, UsersDTO profileDTO);
}