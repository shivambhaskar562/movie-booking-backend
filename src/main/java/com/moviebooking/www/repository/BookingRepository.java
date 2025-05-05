package com.moviebooking.www.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moviebooking.www.entity.Booking;
import com.moviebooking.www.entity.BookingStatus;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{
	
	@Query("select booking from Booking booking where booking.users.id =:usersId")
	Optional<List<Booking>> getUserBooking(long id);
	
	@Query("select booking from Booking booking where booking.show.id =:showId")
	Optional<List<Booking>> getShowBooking(long id);
	
	@Query("select booking from Booking booking where booking.bookingStatus =:bookingStatus")
	Optional<List<Booking>> getBookingStatus(BookingStatus bookingStatus);

}
