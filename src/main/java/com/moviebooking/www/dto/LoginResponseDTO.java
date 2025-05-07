package com.moviebooking.www.dto;

import java.util.Set;

public class LoginResponseDTO {
    private long id;
    private String username;
    private Set<String> roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
