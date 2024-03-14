package com.example.controller;

import com.example.model.member;
import com.example.model.venue;
import com.example.service.venueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AdminVenue")
public class venueController {

    @Autowired
    private venueService venSer;

    @PostMapping
    public void save(@RequestBody venue ven) {
        venSer.insertVenue(ven);
    }

    @PutMapping
    public void update(@RequestBody venue ven) {
        venSer.updateVenue(ven);
    }

    @DeleteMapping("/{roomid}")
    public void delete(@PathVariable String roomid) {
        venSer.deleteVenue(Integer.valueOf(roomid));
    }

    @GetMapping("/{id}")
    public venue getById(@PathVariable String id) {
        return venSer.findVenueById(Integer.valueOf(id));
    }

    @GetMapping("/getAll")
    public List<venue> getAll(){
        List<venue> venlist = venSer.findAllVenues();
        return venlist;
    }
}
