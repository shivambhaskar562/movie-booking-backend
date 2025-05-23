package com.moviebooking.www.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.www.dto.TheaterDTO;
import com.moviebooking.www.entity.Theater;
import com.moviebooking.www.repository.TheaterRepository;
import com.moviebooking.www.service.TheaterService;

@Service
public class TheaterServiceImpl implements TheaterService {

	@Autowired
	TheaterRepository theaterRepository;

	@Override
	public List<Theater> findAllTheaters() {
		return theaterRepository.findAll();
	}

	@Override
	public List<Theater> findTheaterByLocation(String location) {
		List<Theater> theaters = theaterRepository.findByTheaterLocation(location);
		if(theaters.isEmpty()){
				throw new RuntimeException("No theaters found in location: " + location);
		}
		return theaters;
	}


	@Override
	public Theater addTheater(TheaterDTO theaterDTO) {

		Theater theater = new Theater();

		theater.setTheaterName(theaterDTO.getTheaterName());
		theater.setTheaterLocation(theaterDTO.getTheaterLocation());
		theater.setTheaterScreenType(theaterDTO.getTheaterScreenType());
		theater.setTheaterCapacity(theaterDTO.getTheaterCapacity());

		return theaterRepository.save(theater);
	}

	@Override
	public Theater updateTheater(long id, TheaterDTO theaterDTO) {
		Optional<Theater> theaterBox = theaterRepository.findById(id);
		if(theaterBox.isPresent()) {

			Theater theater = theaterBox.get();

			theater.setTheaterName(theaterDTO.getTheaterName());
			theater.setTheaterLocation(theaterDTO.getTheaterLocation());
			theater.setTheaterScreenType(theaterDTO.getTheaterScreenType());
			theater.setTheaterCapacity(theaterDTO.getTheaterCapacity());

			return theaterRepository.save(theater);
		}
		else {
			throw new RuntimeException("No such theater found for this id " + id);
		}
	}

	@Override
	public void deleteTheater(long id) {
		if (!theaterRepository.existsById(id)) {
			throw new RuntimeException("No such theater found with ID: " + id);
		}
		theaterRepository.deleteById(id);
	}


	@Override
	public void deleteAllTheater() {
		theaterRepository.deleteAll();
	}

	@Override
	public Theater findById(long id) {
		return theaterRepository.findById(id)
				.orElseThrow(()-> new RuntimeException("no Such Theater found for this id "+id));
	}

}
