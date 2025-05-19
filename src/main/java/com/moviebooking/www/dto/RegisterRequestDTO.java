package com.moviebooking.www.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class RegisterRequestDTO {

	@NotNull
	private String name;
	@NotNull
	private long mobile;
	@NotNull(message = "Email can't be null")
	@Email
	private String email;

	public @NotNull String getName() {
		return name;
	}

	public void setName(@NotNull String name) {
		this.name = name;
	}

	@NotNull
	public long getMobile() {
		return mobile;
	}

	public void setMobile(@NotNull long mobile) {
		this.mobile = mobile;
	}

	@NotNull
	@Size(min = 6, max = 30)
	private String username;
	@NotNull
	@Size(min = 6, max = 30)
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

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
