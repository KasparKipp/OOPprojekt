package com.projekt.Ridebuddy.api;

import com.projekt.Ridebuddy.rides.model.Ride;
import com.projekt.Ridebuddy.rides.service.RideDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@RequestMapping("Rides")
@RestController
public class InfoController {

    private final RideDataService rideDataService;

    @Autowired
    public InfoController(RideDataService rideDataService) {
        this.rideDataService = rideDataService;
    }

    @PostMapping(path = "{platvorm}")
    public void addRide(@PathVariable("platvorm") String platvorm, @RequestBody Ride ride) {
        rideDataService.addRide(platvorm, ride);
    }

    @GetMapping
    public List<Ride> getAllRides() {
        return rideDataService.getAllRides();
    }

    @GetMapping(path = "{since}")
    public List<Ride> getRides(@PathVariable("since") String since) throws ParseException {
        return rideDataService.getRides(new SimpleDateFormat("yyyy-MM-dd").parse(since));
    }

    // TODO add postMapping to date .csv file
}
