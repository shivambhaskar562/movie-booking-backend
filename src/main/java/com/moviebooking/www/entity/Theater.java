package com.moviebooking.www.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "theater")
public class Theater {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String theaterName;
    private String theaterLocation;
    private String theaterScreenType;
    private int theaterCapacity;

    @OneToMany(mappedBy = "theater", fetch = FetchType.LAZY)
	@JsonIgnore
    private List<Show> shows;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTheaterName() {
        return theaterName;
    }

    public void setTheaterName(String theaterName) {
        this.theaterName = theaterName;
    }

    public String getTheaterLocation() {
        return theaterLocation;
    }

    public void setTheaterLocation(String theaterLocation) {
        this.theaterLocation = theaterLocation;
    }

    public String getTheaterScreenType() {
        return theaterScreenType;
    }

    public void setTheaterScreenType(String theaterScreenType) {
        this.theaterScreenType = theaterScreenType;
    }

    public int getTheaterCapacity() {
        return theaterCapacity;
    }

    public void setTheaterCapacity(int theaterCapacity) {
        this.theaterCapacity = theaterCapacity;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

}
