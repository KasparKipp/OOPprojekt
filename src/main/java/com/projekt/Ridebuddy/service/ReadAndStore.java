package com.projekt.Ridebuddy.service;

import com.projekt.Ridebuddy.dao.RideDao;

public class ReadAndStore {
    private final RideDao rideDao;

    public ReadAndStore(RideDao rideDao) {
        this.rideDao = rideDao;
    }
}
