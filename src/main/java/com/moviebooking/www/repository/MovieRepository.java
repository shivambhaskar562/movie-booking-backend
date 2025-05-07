package com.moviebooking.www.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moviebooking.www.entity.Movie;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository<Movie, Long>{

	Optional<List<Movie>> findByGenre(String genre);
	Optional<List<Movie>> findByLanguage(String language);
	Optional<List<Movie>> findByTitle(String title);
}
