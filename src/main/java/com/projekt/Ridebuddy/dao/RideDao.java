package com.projekt.Ridebuddy.dao;

import com.projekt.Ridebuddy.model.Ride;

import java.time.LocalDateTime;
import java.util.List;

public interface RideDao {
    int insertRide(String platvorm, Ride ride);

    default int insertRide(Ride ride) {
        return insertRide("unknown", ride);
    }
    List<Ride> getRideData(LocalDateTime fromDate);
}
