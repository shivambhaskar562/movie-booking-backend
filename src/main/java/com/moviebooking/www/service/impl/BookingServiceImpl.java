package com.moviebooking.www.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.www.dto.BookingDTO;
import com.moviebooking.www.entity.Booking;
import com.moviebooking.www.entity.BookingStatus;
import com.moviebooking.www.entity.Show;
import com.moviebooking.www.entity.Users;
import com.moviebooking.www.repository.BookingRepository;
import com.moviebooking.www.repository.ShowRepository;
import com.moviebooking.www.repository.UsersRepository;
import com.moviebooking.www.service.BookingService;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	private BookingRepository bookingRepository;

	@Autowired
	private ShowRepository showRepository;

	@Autowired
	private UsersRepository usersRepositary;

	@Override
	public Booking createBooking(BookingDTO bookingDTO) {
		Show show = showRepository.findById(bookingDTO.getShowId())
				.orElseThrow(() -> new RuntimeException("No such show found for id" + bookingDTO.getShowId()));

		if (!isSeatAvailable(show, bookingDTO.getNoOfSeats())) {
			throw new RuntimeException(bookingDTO.getNoOfSeats() + " No of seat is not available only ");
		}

		// Checking the no of seat and selected seatno is equal or not
		if (bookingDTO.getSeatNumbers() == null || bookingDTO.getNoOfSeats() != bookingDTO.getSeatNumbers().size()) {
			throw new RuntimeException("No of seat " + bookingDTO.getNoOfSeats() + " is not equal to  seat selected"
					+ bookingDTO.getSeatNumbers().size());
		}
		// checking the same seat no is not booked again
		if (isDuplicateSeat(show, bookingDTO.getSeatNumbers())) {
			throw new RuntimeException("Selected seat no is already booked");
		}

		Users users = usersRepositary.findById(bookingDTO.getUserId()).orElseThrow(() -> new RuntimeException());

		Booking booking = new Booking();
		booking.setNoOfSeats(bookingDTO.getNoOfSeats());
		booking.setBookingStatus(BookingStatus.PENDING);
		booking.setBookingTime(LocalDateTime.now());
		booking.setPrice(calculatePrice(bookingDTO.getNoOfSeats(), show.getPrice()));
		booking.setSeatNumbers(bookingDTO.getSeatNumbers());
		booking.setShow(show);
		booking.setUsers(users);

		return bookingRepository.save(booking);
	}

	private double calculatePrice(int noOfSeat, double price) {
		return noOfSeat * price;
	}

	private boolean isDuplicateSeat(Show show, List<String> bookingSeats) {
		List<Booking> allSeat = show.getBookings();
		for (Booking booking : allSeat) {
			if (booking.getBookingStatus() != BookingStatus.CANCELLED) {
				for (String bookedSeat : booking.getSeatNumbers()) {
					if (bookingSeats.contains(bookedSeat)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean isSeatAvailable(Show show, int noOfSeat) {

		List<Booking> listOfBookings = show.getBookings();
		int noOfSeatBooked = 0;
		for (Booking booking : listOfBookings) {
			noOfSeatBooked += booking.getSeatNumbers().size();

		}

		if (show.getTheater().getTheaterCapacity() - noOfSeatBooked >= noOfSeat) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Booking> getUserBooking(long id) {
		return bookingRepository.getUserBooking(id)
				.orElseThrow(() -> new RuntimeException("No such booking found for 	id " + id));
	}

	@Override
	public List<Booking> getShowBooking(long id) {
		return bookingRepository.getShowBooking(id)
				.orElseThrow(() -> new RuntimeException("No such show found for id " + id));
	}

	@Override
	public Booking confirmBooking(long id) {
		Booking booking = bookingRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("No such booking found for this id " + id));
		if (booking.getBookingStatus() != BookingStatus.PENDING) {
			throw new RuntimeException("No such show found for id " + id);
		}

		// Implement Payment page here
		booking.setBookingStatus(BookingStatus.CONFIRMED);

		return bookingRepository.save(booking);
	}

	@Override
	public Booking cancelBooking(long id) {
		Booking booking = bookingRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("No such booking found for this id " + id));

		if (booking.getBookingStatus() == BookingStatus.CANCELLED) {
			throw new RuntimeException("Booking is already been cancelled ");
		}

		// Implement The payment cancelation logic
		booking.setBookingStatus(BookingStatus.CANCELLED);

		return bookingRepository.save(booking);
	}

	@Override
	public List<Booking> getBookingStatus(BookingStatus bookingStatus) {
		return bookingRepository.getBookingStatus(bookingStatus)
				.orElseThrow(() -> new RuntimeException("No Such booking found for this status " + bookingStatus));
	}

}
