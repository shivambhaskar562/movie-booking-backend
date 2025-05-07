package com.moviebooking.www.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviebooking.www.dto.ShowDTO;
import com.moviebooking.www.entity.Booking;
import com.moviebooking.www.entity.Movie;
import com.moviebooking.www.entity.Show;
import com.moviebooking.www.entity.Theater;
import com.moviebooking.www.repository.MovieRepository;
import com.moviebooking.www.repository.ShowRepository;
import com.moviebooking.www.repository.TheaterRepository;
import com.moviebooking.www.service.ShowService;

@Service
public class ShowServiceImpl implements ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Override
    public List<Show> getAllShow() {
        return showRepository.findAll();
    }

    @Override
    public List<Show> getShowByMovies(String movie) {
        Optional<List<Show>> showListBox = showRepository.getShowByMovie(movie);
        if (showListBox.isPresent()) {
            return showListBox.get();
        } else {
            throw new RuntimeException("No such movie Show for movie " + movie);
        }
    }

    @Override
    public List<Show> getShowByTheater(long id) {

        List<Show> shows = showRepository.findAll();
        List<Show> resultShows = new ArrayList<>();

        for(Show show : shows){
            Theater theater =  show.getTheater();
            if(theater.getId() == id){
                resultShows.add(show);
            }
        }
        return resultShows;
    }

    @Override
    public Show addShow(ShowDTO showDTO) {
        Movie movie = movieRepository.findById(showDTO.getMovieId())
                .orElseThrow(() -> new RuntimeException("No such movie found for this ID " + showDTO.getMovieId()));
        Theater theater = theaterRepository.findById(showDTO.getTheaterId())
                .orElseThrow(() -> new RuntimeException("No such theater found for this ID " + showDTO.getTheaterId()));

        Show show = new Show();
        show.setMovie(movie);
        show.setTheater(theater);
        show.setPrice(showDTO.getPrice());
        show.setShowTime(showDTO.getShowTime());
        return showRepository.save(show);
    }

    @Override
    public Show updateShow(long id, ShowDTO showDTO) {
        Show show = showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such show found for this ID " + id));

        Movie movie = movieRepository.findById(showDTO.getMovieId())
                .orElseThrow(() -> new RuntimeException("No such movie found for this ID " + showDTO.getMovieId()));
        Theater theater = theaterRepository.findById(showDTO.getTheaterId())
                .orElseThrow(() -> new RuntimeException("No such theater found for this ID " + showDTO.getTheaterId()));

        show.setMovie(movie);
        show.setTheater(theater);
        show.setPrice(showDTO.getPrice());
        show.setShowTime(showDTO.getShowTime());
        return showRepository.save(show);
    }

    @Override
    public void deleteShow(long id) {

        Show show = showRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Nosuch show found for this ID " + id));

        List<Booking> bookings = show.getBookings();
        if (bookings.isEmpty()) {
            showRepository.delete(show);
        } else {
            throw new RuntimeException("You can not delete show there is booking");
        }

    }

    @Override
    public void deleteAllShow() {
        List<Show> shows = showRepository.findAll();
        for (Show show : shows) {
            List<Booking> bookings = show.getBookings();
            if (bookings.isEmpty()) {
                showRepository.delete(show);
            }
        }
    }

    @Override
    public List<Show> getShowByMovieById(long id) {

        List<Show> shows = showRepository.findAll();
        List<Show> resultShows = new ArrayList<>();
        for(Show show : shows){
            Movie m =  show.getMovie();
            if(m.getId() == id){
                resultShows.add(show);
            }
        }
        return resultShows;
    }

}
