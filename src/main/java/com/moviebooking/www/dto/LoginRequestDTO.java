package com.moviebooking.www.dto;

import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public class LoginRequestDTO {

    @NotNull(message = "Username can not be null")
    @Length(min = 6, max = 30)
    private String username;

    @NotNull(message = "Password can not be null")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
