package com.moviebooking.www.service;

import java.util.List;

import com.moviebooking.www.dto.BookingDTO;
import com.moviebooking.www.entity.Booking;
import com.moviebooking.www.entity.BookingStatus;

public interface BookingService {
	
	Booking createBooking(BookingDTO bookingDTO);
	List<Booking> getUserBooking(long id);
	List<Booking> getShowBooking(long id);
	Booking confirmBooking(long id);
	Booking cancelBooking(long id);
	List<Booking> getBookingStatus(BookingStatus bookingStatus);
	
}
