package com.moviebooking.www.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moviebooking.www.entity.Booking;
import com.moviebooking.www.entity.BookingStatus;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
	
	@Query("select booking from Booking booking where booking.users.id =:id")
	List<Booking> findUserBooking(long id);
	
	@Query("select booking from Booking booking where booking.show.id =:id")
	List<Booking> findAllBookingByShow(long id);

	@Query("select booking from Booking booking where booking.show.movie.id =:id")
	List<Booking> findAllBookingByMovie(long id);
	
//	@Query("select booking from Booking booking where booking.bookingStatus =:bookingStatus")
//	List<Booking> findBookingStatus(BookingStatus bookingStatus);
}
