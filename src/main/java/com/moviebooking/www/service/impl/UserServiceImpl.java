package com.moviebooking.www.service.impl;

import com.moviebooking.www.dto.UsersDTO;
import com.moviebooking.www.entity.Users;
import com.moviebooking.www.repository.UsersRepository;
import com.moviebooking.www.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public Users UserProfile(String username) {
        return usersRepository.findByUsername(username)
                .orElseGet(() -> usersRepository.findByEmail(username)
                        .orElseThrow(() -> new RuntimeException("No user exists with this username/email: " + username)));
    }

    @Override
    public Users updateUserProfile(String username, UsersDTO profileDTO) {
        Users users =  usersRepository.findByUsername(username)
                .orElseGet(() -> usersRepository.findByEmail(username)
                        .orElseThrow(() -> new RuntimeException("No user exists with this username/email: " + username)));

        users.setEmail(users.getEmail());
        users.setPassword(users.getPassword());

        return usersRepository.save(users);
    }
}