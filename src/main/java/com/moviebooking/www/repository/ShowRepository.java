package com.moviebooking.www.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.moviebooking.www.entity.Show;

@Repository
public interface ShowRepository extends JpaRepository<Show, Long>{
	
	@Query("SELECT s FROM Show s WHERE s.theater.theaterName = :theaterName")
	Optional<List<Show>> getShowByTheater(String theater);
	
	@Query("SELECT s FROM Show s WHERE s.movie.title = :movieTitle")
	Optional<List<Show>> getShowByMovie(String movie);
}
