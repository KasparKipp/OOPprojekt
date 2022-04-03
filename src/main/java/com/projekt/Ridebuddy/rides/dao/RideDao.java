package com.projekt.Ridebuddy.rides.dao;

import com.projekt.Ridebuddy.rides.model.Ride;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public interface RideDao {
    int insertRide(String platvorm, Ride ride);

    default int insertRide(Ride ride) {
        return insertRide("unknown", ride);
    }

    List<Ride> getRideData(LocalDateTime fromDate);
    List<Ride> getRideData(String platvorm, LocalDateTime fromDate);

    // for data on all rides get all rides from the turn of the millennia
    default List<Ride> getRideData(){
        return getRideData(LocalDateTime.parse("2000-01-01T00:00", DateTimeFormatter.ISO_LOCAL_DATE_TIME));
    }
    // for all rides on a specific platform get all rides from that platform from 01.01.200
    default List<Ride> getRideData(String platvorm){
        return getRideData(platvorm, LocalDateTime.of(
                2000,
                1,
                1,
                0,
                0,
                0));
    }
}
