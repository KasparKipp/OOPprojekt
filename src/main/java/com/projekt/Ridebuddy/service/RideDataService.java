package com.projekt.Ridebuddy.service;

import com.projekt.Ridebuddy.dao.RideDao;
import com.projekt.Ridebuddy.model.Ride;
import com.projekt.Ridebuddy.model.RideDateFormater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class RideDataService {

    private final RideDao rideDao;

    @Autowired
    public RideDataService(@Qualifier("SampleDao") RideDao rideDao) {
        this.rideDao = rideDao;
    }

    public int addRide(String platvorm, Ride ride) { return rideDao.insertRide(platvorm, ride); }

    public List<Ride> getAllRides() { return rideDao.getRideData(); }

    public List<Ride> getRides(LocalDateTime sinceThisTime) { return rideDao.getRideData(sinceThisTime); }
}
