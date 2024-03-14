package com.example.service.serviceImpl;

import com.example.dao.venueDao;
import com.example.model.venue;
import com.example.service.venueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class venueServiceImpl implements venueService {

    @Autowired
    private venueDao venDao;
    @Override
    public void insertVenue(venue room) {
        venDao.insert(room);
    }

    @Override
    public void updateVenue(venue room) {
        venDao.update(room);
    }

    @Override
    public void deleteVenue(Integer roomid) {
        venDao.delete(roomid);
    }

    @Override
    public venue findVenueById(Integer roomid) {
        return venDao.findById(roomid);
    }

    @Override
    public List<venue> findAllVenues() {
        return venDao.findAll();
    }
}
