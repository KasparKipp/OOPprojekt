package com.projekt.Ridebuddy.rides.service;

import com.projekt.Ridebuddy.rides.dao.RideDao;
import com.projekt.Ridebuddy.rides.model.Ride;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    public List<Ride> getRides(Date sinceThisTime) { return rideDao.getRideData(sinceThisTime); }
}
