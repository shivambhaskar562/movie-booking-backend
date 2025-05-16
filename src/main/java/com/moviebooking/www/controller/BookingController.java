package com.moviebooking.www.controller;

import com.moviebooking.www.entity.Booking;
import com.moviebooking.www.response.ResponseStructure;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.moviebooking.www.dto.BookingDTO;
import com.moviebooking.www.service.BookingService;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/booking")
@CrossOrigin(origins = "http://127.0.0.1:3000")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    //Start Booking
    @PostMapping
    public ResponseEntity<ResponseStructure<Booking>> createBooking(@RequestBody @Valid BookingDTO bookingDTO) {
        Booking booking = bookingService.createBooking(bookingDTO);

        ResponseStructure<Booking> responseStructure = new ResponseStructure<>();
        responseStructure.setStatus("Success");
        responseStructure.setStatusCode(HttpStatus.CREATED.value());
        responseStructure.setMessage("Booking created");
        responseStructure.setDateTime(LocalDateTime.now());
        responseStructure.setData(booking);

        return new ResponseEntity<>(responseStructure, HttpStatus.CREATED);
    }


    // Payment page integrate
    @PutMapping("/{id}/confirm")
    public ResponseEntity<ResponseStructure<Booking>> confirmBooking(@PathVariable long id) {
        Booking booking = bookingService.confirmBooking(id);

        ResponseStructure<Booking> responseStructure = new ResponseStructure<>();

        responseStructure.setStatus("Success");
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Booking successfully");
        responseStructure.setDateTime(LocalDateTime.now());
        responseStructure.setData(booking);
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    @PutMapping("/{id}/cancel")
    public ResponseEntity<ResponseStructure<Booking>> cancelBooking(@PathVariable long id) {
        Booking booking = bookingService.cancelBooking(id);

        ResponseStructure<Booking> responseStructure = new ResponseStructure<>();

        responseStructure.setStatus("Success");
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Booking canceled successfully");
        responseStructure.setDateTime(LocalDateTime.now());
        responseStructure.setData(booking);
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<ResponseStructure<List<Booking>>> findBookingByUsers(@PathVariable long id) {
        List<Booking> bookings = bookingService.findUserBooking(id);

        ResponseStructure<List<Booking>> responseStructure = new ResponseStructure<>();

        responseStructure.setStatus("Success");
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("User's bookings fetched successfully");
        responseStructure.setDateTime(LocalDateTime.now());
        responseStructure.setData(bookings);
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);

    }


    //Admin access
    @GetMapping("/show/{id}")
    public ResponseEntity<ResponseStructure<List<Booking>>> findAllBookingByShow(@PathVariable long id) {
        List<Booking> bookings = bookingService.findAllBookingByShow(id);

        ResponseStructure<List<Booking>> responseStructure = new ResponseStructure<>();

        responseStructure.setStatus("Success");
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("All Booking Details");
        responseStructure.setDateTime(LocalDateTime.now());
        responseStructure.setData(bookings);
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    //Admin access
    @GetMapping("/movie/{id}")
    public ResponseEntity<ResponseStructure<List<Booking>>> findAllBookingByMovie(@PathVariable long id) {
        List<Booking> bookings = bookingService.findAllBookingByMovie(id);

        ResponseStructure<List<Booking>> responseStructure = new ResponseStructure<>();

        responseStructure.setStatus("Success");
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("All Booking Details");
        responseStructure.setDateTime(LocalDateTime.now());
        responseStructure.setData(bookings);
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

    //Admin access
    @GetMapping("/all")
    public ResponseEntity<ResponseStructure<List<Booking>>> findAllBooking() {
        List<Booking> bookings = bookingService.findAllBooking();

        ResponseStructure<List<Booking>> responseStructure = new ResponseStructure<>();

        responseStructure.setStatus("Success");
        responseStructure.setStatusCode(HttpStatus.OK.value());
        responseStructure.setMessage("Details fetched successfully");
        responseStructure.setDateTime(LocalDateTime.now());
        responseStructure.setData(bookings);
        return new ResponseEntity<>(responseStructure, HttpStatus.OK);
    }

}
