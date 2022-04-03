package com.projekt.Ridebuddy.rides.service;

import com.projekt.Ridebuddy.rides.dao.RideDao;

public class ReadAndStore {
    private final RideDao rideDao;

    public ReadAndStore(RideDao rideDao) {
        this.rideDao = rideDao;
    }
}
