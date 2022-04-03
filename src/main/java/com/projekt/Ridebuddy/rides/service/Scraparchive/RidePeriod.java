package com.projekt.Ridebuddy.rides.service.Scraparchive;

import com.projekt.Ridebuddy.rides.dao.RideDao;

public abstract class RidePeriod {
    private final RideDao rideDao;

    public RidePeriod(RideDao rideDao) {
        this.rideDao = rideDao;
    }

    public abstract void getPeriodInfo();

    //TODO: Siia lisada meetodid perioodi kõige tulusama päeva ja tunni leidmiseks
    
}
