package com.moviebooking.www.dto;

import java.util.Set;

public class LoginResponseDTO {
    private String username;
    private Set<String> roles;

    // Constructor
    public LoginResponseDTO() {
    }

    public LoginResponseDTO(String username, Set<String> roles) {
        this.username = username;
        this.roles = roles;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }
}
