package com.moviebooking.www.controller;

import com.moviebooking.www.entity.Theater;
import com.moviebooking.www.dto.TheaterDTO;
import com.moviebooking.www.response.ResponseStructure;
import com.moviebooking.www.service.TheaterService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/theater")
public class TheaterController {

	@Autowired
	private TheaterService theaterService;

	@GetMapping
	public ResponseEntity<ResponseStructure<List<Theater>>> findAllTheater() {
		List<Theater> theaters = theaterService.findAllTheaters();

		ResponseStructure<List<Theater>> response = new ResponseStructure<>();

		response.setStatus("Success");
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("All Theaters Fetched");
		response.setDateTime(LocalDateTime.now());
		response.setData(theaters);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("id/{id}")
	public ResponseEntity<ResponseStructure<Theater>> findById(@PathVariable long id) {
		Theater theater = theaterService.findById(id);

		ResponseStructure<Theater> response = new ResponseStructure<>();

		response.setStatus("Success");
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Theater Fetched");
		response.setDateTime(LocalDateTime.now());
		response.setData(theater);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@GetMapping("/{location}")
	public ResponseEntity<ResponseStructure<List<Theater>>> findTheaterByLocation(@PathVariable String location) {
		List<Theater> theaters = theaterService.findTheaterByLocation(location);

		ResponseStructure<List<Theater>> response = new ResponseStructure<>();

		response.setStatus("Success");
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Theaters by Location Fetched");
		response.setDateTime(LocalDateTime.now());
		response.setData(theaters);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// Admin access
	@PostMapping
	public ResponseEntity<ResponseStructure<Theater>> addTheater(@RequestBody @Valid TheaterDTO theaterDTO) {
		Theater theater = theaterService.addTheater(theaterDTO);

		ResponseStructure<Theater> response = new ResponseStructure<>();

		response.setStatus("Success");
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Theater Created");
		response.setDateTime(LocalDateTime.now());
		response.setData(theater);

		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

	// Admin access
	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<Theater>> updateTheater(@PathVariable long id, @RequestBody @Valid TheaterDTO theaterDTO) {
		Theater theater = theaterService.updateTheater(id, theaterDTO);

		ResponseStructure<Theater> response = new ResponseStructure<>();

		response.setStatus("Success");
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Theater Updated");
		response.setDateTime(LocalDateTime.now());
		response.setData(theater);

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// Admin access
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<?>> deleteTheater(@PathVariable long id) {
		theaterService.deleteTheater(id);

		ResponseStructure<?> response = new ResponseStructure<>();

		response.setStatus("Success");
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Theater Deleted");
		response.setDateTime(LocalDateTime.now());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	// Admin access
	@DeleteMapping
	public ResponseEntity<ResponseStructure<?>> deleteAllTheater() {
		theaterService.deleteAllTheater();

		ResponseStructure<?> response = new ResponseStructure<>();

		response.setStatus("Success");
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("All Theaters Deleted");
		response.setDateTime(LocalDateTime.now());

		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
