package com.projekt.Ridebuddy.rides.dao;

import com.projekt.Ridebuddy.rides.model.Ride;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

public interface RideDao {
    int insertRide(String platvorm, Ride ride);

    default int insertRide(Ride ride) {
        return insertRide("unknown", ride);
    }

    List<Ride> getRideData(Date fromDate);
    List<Ride> getRideData(String platvorm, Date fromDate);

    // for data on all rides get all rides from the turn of the millennia
    default List<Ride> getRideData(){
        return getRideData(new Date(946677600000L));
    }
    // for all rides on a specific platform get all rides from that platform from 01.01.2002
    default List<Ride> getRideData(String platvorm){
        return getRideData(platvorm, new Date(946677600000L));
    }
}
