package com.projekt.Ridebuddy.rides.service.Scraparchive;

import com.projekt.Ridebuddy.rides.dao.RideDao;

import java.time.LocalDateTime;

public class CurrentMonth extends RidePeriod {
    private int periodRideDistance = 0;
    private double periodTotalIncome = 0;


    public CurrentMonth(RideDao rideDao) {
        super(rideDao);
    }

    @Override
    public void getPeriodInfo() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime date = LocalDateTime.of(
                now.getYear(),
                now.getMonthValue(),
                1,
                0,
                0,
                0);
        /*for (Ride ride:rideDao.getRideData(date)) {
            periodRideDistance += ride.getRideDistance();
            periodTotalIncome += ride.getRideIncome();

        }*/
    }
}
