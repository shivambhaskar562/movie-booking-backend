package com.moviebooking.www.service;

import java.util.List;

import com.moviebooking.www.dto.BookingDTO;
import com.moviebooking.www.entity.Booking;
import com.moviebooking.www.entity.BookingStatus;

public interface BookingService {
	
	Booking createBooking(BookingDTO bookingDTO);
	List<Booking> findUserBooking(long id);
	List<Booking> findShowBooking(long id);
	Booking confirmBooking(long id);
	Booking cancelBooking(long id);
	List<Booking> findAllBooking();
	
}
