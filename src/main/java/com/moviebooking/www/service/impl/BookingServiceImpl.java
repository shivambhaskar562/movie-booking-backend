package com.moviebooking.www.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import com.moviebooking.www.dto.BookingDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private UsersRepository usersRepository;

    @Override
    public Booking createBooking(BookingDTO bookingDTO) {

        Show show = showRepository.findById(bookingDTO.getShowId())
                .orElseThrow(()-> new RuntimeException(" No such show available for this "+bookingDTO.getShowId()));

        Users users = usersRepository.findById(bookingDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("No such user found for id " + bookingDTO.getUserId()));


        Booking booking = new Booking();

        booking.setNoOfSeats(bookingDTO.getNoOfSeats());
        booking.setSeatNumbers(bookingDTO.getSeatNumbers());
        booking.setBookingTime(LocalDateTime.now());
        booking.setShow(show);
        booking.setUsers(users);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setPrice(calculatePrice(booking.getNoOfSeats(), show.getPrice()));

        //IS seat Available
        if (!isSeatAvailable(show, booking.getNoOfSeats())) {
            throw new RuntimeException(booking.getNoOfSeats() + " No of seat is not available only ");
        }

        // Checking the no of seat and selected seatNo is equal or not
        if (booking.getSeatNumbers() == null || booking.getNoOfSeats() != booking.getSeatNumbers().size()) {
            throw new RuntimeException("No of seat " + booking.getNoOfSeats() + " is not equal to  seat selected"
                    + booking.getSeatNumbers().size());
        }

        // checking the same seat no is not booked again
        if (isDuplicateSeat(show, booking.getSeatNumbers())) {
            throw new RuntimeException("Selected seat no is already booked");
        }

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

        return show.getTheater().getTheaterCapacity() - noOfSeatBooked >= noOfSeat;
    }

    @Override
    public List<Booking> findUserBooking(long id) {
        List<Booking> bookings = bookingRepository.findUserBooking(id);
        if(bookings.isEmpty()){
            throw new RuntimeException("No such booking found for 	id " + id);
        }
        return bookings;
    }

    @Override
    public List<Booking> findAllBookingByShow(long id) {
        List<Booking> bookings = bookingRepository.findAllBookingByShow(id);
        if(bookings.isEmpty()){
            throw  new RuntimeException("No such booking found for id " + id);
        }
        return bookings;
    }

    @Override
    public List<Booking> findAllBookingByMovie(long id) {
        List<Booking> bookings = bookingRepository.findAllBookingByMovie(id);
        if(bookings.isEmpty()){
            throw new RuntimeException("No such booking found for id " + id);
        }

        return bookings;
    }

    @Override
    public Booking confirmBooking(long id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such booking found for this id " + id));

        if (booking.getBookingStatus() != BookingStatus.PENDING) {
            throw new RuntimeException("Booking is not in a PENDING state for confirmation");
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

        // Implement The payment cancellation logic
        booking.setBookingStatus(BookingStatus.CANCELLED);

        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> findAllBooking() {
        return bookingRepository.findAll();
    }

}
