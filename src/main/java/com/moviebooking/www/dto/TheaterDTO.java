package com.moviebooking.www.dto;

import jakarta.validation.constraints.NotNull;

public class TheaterDTO {
	@NotNull
	private String theaterName;
	@NotNull
	private String theaterLocation;
	@NotNull
	private String theaterScreenType;
	@NotNull
	private int theaterCapacity;

	public String getTheaterName() {
		return theaterName;
	}

	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	public String getTheaterLocation() {
		return theaterLocation;
	}

	public void setTheaterLocation(String theaterLocation) {
		this.theaterLocation = theaterLocation;
	}

	public String getTheaterScreenType() {
		return theaterScreenType;
	}

	public void setTheaterScreenType(String theaterScreenType) {
		this.theaterScreenType = theaterScreenType;
	}

	public int getTheaterCapacity() {
		return theaterCapacity;
	}

	public void setTheaterCapacity(int theaterCapacity) {
		this.theaterCapacity = theaterCapacity;
	}

}
