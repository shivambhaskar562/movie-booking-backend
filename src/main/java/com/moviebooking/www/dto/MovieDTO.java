package com.moviebooking.www.dto;

import jakarta.validation.constraints.NotNull;

public class MovieDTO {

	@NotNull(message = "Movie Title Can not be Null")
	private String title;
	private String description;

	@NotNull(message = "Genre Can not be Null")
	private String genre;

	@NotNull(message = "Please provide language")
	private String language;

	@NotNull
	private String duration;
	@NotNull
	private String releaseDate;

	@NotNull
	public String getDescription() {
		return description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}

}
