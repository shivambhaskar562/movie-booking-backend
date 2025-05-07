package com.moviebooking.www.entity;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int noOfSeats;
	private LocalDateTime bookingTime;
	private double price;
	private BookingStatus bookingStatus;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "booking_seat_no")
	private List<String> seatNumbers;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Users users;

	@ManyToOne(fetch = FetchType.EAGER)
	private Show show;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public LocalDateTime getBookingTime() {
		return bookingTime;
	}

	public void setBookingTime(LocalDateTime bookingTime) {
		this.bookingTime = bookingTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

	public List<String> getSeatNumbers() {
		return seatNumbers;
	}

	public void setSeatNumbers(List<String> seatNumbers) {
		this.seatNumbers = seatNumbers;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

}
