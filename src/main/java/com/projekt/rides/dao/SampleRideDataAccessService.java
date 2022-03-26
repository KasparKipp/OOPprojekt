package com.projekt.rides.dao;

import com.projekt.rides.model.Ride;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class SampleRideDataAccessService implements RideDao{
    private static List<Ride> DB_BOLT = new ArrayList<>();
    private static List<Ride> DB_UBER = new ArrayList<>();


    @Override
    public int insertRide(String platvorm, Ride ride) {
        if (Objects.equals(platvorm, "UBER")) {
            DB_UBER.add(ride);
        } else if (Objects.equals(platvorm, "BOLT")) {
            DB_BOLT.add(ride);
        } else return -1;
        return 1;
    }

    public List<Ride> getRideData(LocalDateTime fromDate) {
        //TODO
        return null;
    }

}
