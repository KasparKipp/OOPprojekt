package com.projekt.rides.service;

import com.projekt.rides.dao.RideDao;

public abstract class RidePeriod {
    final RideDao rideDao;

    public RidePeriod(RideDao rideDao) {
        this.rideDao = rideDao;
    }

    public abstract void getPeriodInfo();

    //TODO: Siia lisada meetodid perioodi kõige tulusama päeva ja tunni leidmiseks
    
}
