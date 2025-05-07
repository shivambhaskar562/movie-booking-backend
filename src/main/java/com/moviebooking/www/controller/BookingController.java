package com.moviebooking.www.controller;

import com.moviebooking.www.entity.Booking;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.moviebooking.www.dto.BookingDTO;
import com.moviebooking.www.entity.BookingStatus;
import com.moviebooking.www.service.BookingService;

import java.util.List;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class BookingController {

	@Autowired
	private BookingService bookingService;

	@PostMapping
	public ResponseEntity<Booking> newBooking(@RequestBody @Valid BookingDTO bookingDTO) {
		return ResponseEntity.ok(bookingService.createBooking(bookingDTO));
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<List<Booking>> findBookingByUer(@PathVariable long id) {
		return ResponseEntity.ok(bookingService.findUserBooking(id));
	}

	@GetMapping("/show/{id}")
	public ResponseEntity<List<Booking>> findBookingByShow(@PathVariable long id) {
		return ResponseEntity.ok(bookingService.findShowBooking(id));
	}
	// Payment page integrate
	@PutMapping("/{id}/confirm")
	public ResponseEntity<Booking> conformBooking(@PathVariable long id) {
		return ResponseEntity.ok(bookingService.confirmBooking(id));
	}

	@PutMapping("/{id}/cancel")
	public ResponseEntity<Booking> cancelBooking(@PathVariable long id) {
		return ResponseEntity.ok(bookingService.cancelBooking(id));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Booking>> findAllBooking() {
		return ResponseEntity.ok(bookingService.findAllBooking());
	}

}
