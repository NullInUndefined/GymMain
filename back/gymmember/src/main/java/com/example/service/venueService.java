package com.example.service;

import com.example.model.venue;

import java.util.List;

public interface venueService {
    void insertVenue(venue room);
    void updateVenue(venue room);
    void deleteVenue(Integer roomid);
    venue findVenueById(Integer roomid);
    List<venue> findAllVenues();
}
