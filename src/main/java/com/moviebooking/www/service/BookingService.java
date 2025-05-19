package com.moviebooking.www.service;

import java.util.List;

import com.moviebooking.www.dto.BookingDTO;
import com.moviebooking.www.entity.Booking;

public interface BookingService {
	
	Booking createBooking(BookingDTO bookingDTO);
	Booking findById(long id);
	List<Booking> findUserBooking(long id);
	List<Booking> findAllBookingByShow(long id);
	List<Booking> findAllBookingByMovie(long id);
	Booking confirmBooking(long id);
	Booking cancelBooking(long id);
	List<Booking> findAllBooking();
	
}
