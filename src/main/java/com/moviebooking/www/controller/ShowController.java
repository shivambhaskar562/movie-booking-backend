package com.moviebooking.www.controller;

import com.moviebooking.www.entity.Show;
import com.moviebooking.www.response.ResponseStructure;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.moviebooking.www.dto.ShowDTO;
import com.moviebooking.www.service.ShowService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/show")
public class ShowController {

	@Autowired
	ShowService showService;

	@GetMapping
	public ResponseEntity<ResponseStructure<List<Show>>> findAllShow() {
		List<Show> shows = showService.findAllShow();

		ResponseStructure<List<Show>> responseStructure = new ResponseStructure<>();

		responseStructure.setStatus("Success ");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Founded List of Shows");
		responseStructure.setDateTime(LocalDateTime.now());
		responseStructure.setData(shows);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Show>> findById(@PathVariable  long id) {
		Show show = showService.findById(id);

		ResponseStructure<Show> responseStructure = new ResponseStructure<>();

		responseStructure.setStatus("Success");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Shows found");
		responseStructure.setDateTime(LocalDateTime.now());
		responseStructure.setData(show);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@GetMapping("/movie/{id}")
	public ResponseEntity<ResponseStructure<List<Show>>> findByMovieId(@PathVariable  long id) {
		List<Show> shows = showService.findByMovieId(id);

		ResponseStructure<List<Show>> responseStructure = new ResponseStructure<>();

		responseStructure.setStatus("Success");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Founded List of Shows");
		responseStructure.setDateTime(LocalDateTime.now());
		responseStructure.setData(shows);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	@GetMapping("/theater/{theaterId}")
	public ResponseEntity<ResponseStructure<List<Show>>> findByTheaterId(@PathVariable long theaterId) {
		List<Show> shows = showService.findByTheaterId(theaterId);

		ResponseStructure<List<Show>> responseStructure = new ResponseStructure<>();

		responseStructure.setStatus("Success");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Founded List of Shows");
		responseStructure.setDateTime(LocalDateTime.now());
		responseStructure.setData(shows);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	// Admin access
	@PostMapping
	public ResponseEntity<ResponseStructure<Show>> addShow(@RequestBody @Valid ShowDTO showDTO) {
		Show show = showService.addShow(showDTO);

		ResponseStructure<Show> responseStructure = new ResponseStructure<>();

		responseStructure.setStatus("Success");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Show Created");
		responseStructure.setDateTime(LocalDateTime.now());
		responseStructure.setData(show);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	// Admin access
	@PutMapping("/{id}")
	public ResponseEntity<ResponseStructure<Show>> updateShow(@PathVariable long id, @RequestBody @Valid ShowDTO showDTO) {
		Show show = showService.updateShow(id, showDTO);

		ResponseStructure<Show> responseStructure = new ResponseStructure<>();

		responseStructure.setStatus("Success");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("List of shows found");
		responseStructure.setDateTime(LocalDateTime.now());
		responseStructure.setData(show);
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	// Admin access
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<?>> deleteShow(@PathVariable long id) {
		showService.deleteShow(id);

		ResponseStructure<?> responseStructure = new ResponseStructure<>();

		responseStructure.setStatus("Success");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Show deleted");
		responseStructure.setDateTime(LocalDateTime.now());
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	// Admin access
	@DeleteMapping
	public ResponseEntity<ResponseStructure<?>> deleteAllShow() {
		showService.deleteAllShow();

		ResponseStructure<?> responseStructure = new ResponseStructure<>();

		responseStructure.setStatus("Success");
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Founded List of Shows");
		responseStructure.setDateTime(LocalDateTime.now());
		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}
}
