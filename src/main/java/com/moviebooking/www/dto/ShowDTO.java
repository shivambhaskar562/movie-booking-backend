package com.moviebooking.www.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public class ShowDTO {
	@NotNull
	private LocalDateTime showTime;
	@NotNull
	private double price;
	@NotNull
	private long movieId;
	@NotNull
	private long theaterId;

	public LocalDateTime getShowTime() {
		return showTime;
	}

	public void setShowTime(LocalDateTime showTime) {
		this.showTime = showTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public long getTheaterId() {
		return theaterId;
	}

	public void setTheaterId(long theaterId) {
		this.theaterId = theaterId;
	}

}
