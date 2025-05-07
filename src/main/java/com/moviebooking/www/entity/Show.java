package com.moviebooking.www.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "show")
public class Show {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime showTime;
	private double price;

	@ManyToOne(fetch = FetchType.EAGER)
	private Movie movie;

	@ManyToOne(fetch = FetchType.EAGER)
	private Theater theater;

	@OneToMany(fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Booking> bookings;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

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

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Theater getTheater() {
		return theater;
	}

	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

}
