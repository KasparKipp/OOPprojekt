package com.projekt.Ridebuddy.rides.dao;

import com.projekt.Ridebuddy.rides.model.Ride;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

@Repository("SampleDao")
@NoArgsConstructor
public class SampleRideDataAccessService implements RideDao{


    @Override
    public int insertRide(String platvorm, Ride ride) {
        if (Objects.equals(platvorm.toUpperCase(), "UBER")) {
            DB_UBER.add(new Ride(
                    ride.getRideDate(),
                    ride.getRideAddress(),
                    ride.getPrice(),
                    ride.getCancellationFee(),
                    ride.getTip(),
                    ride.getCurrency(),
                    ride.getCurrency(),
                    ride.getPaymentMethod(),
                    ride.getTimeOfPayment()));
        } else if (Objects.equals(platvorm.toUpperCase(), "BOLT")) {
            DB_BOLT.add(ride);
        } else return -1;
        return 1;
    }

    @Override
    public List<Ride> getRideData(Date fromDate) {
        // Probleem selles, et praegu see meetod ei ole lihtsasti skaleeritav
        // ja toimib vaid 2 DB-ga.
        Deque<Ride> uber = DB_UBER.stream()
                .filter(ride -> ride.getRideDate() < fromDate.getTime())
                .collect(toCollection(ArrayDeque::new));
        Deque<Ride> bolt = DB_BOLT.stream()
                .filter(ride -> ride.getRideDate() < fromDate.getTime())
                .collect(toCollection(ArrayDeque::new));
        List<Ride> result = new ArrayList<>(uber.size() + bolt.size());
        while (!uber.isEmpty() && !bolt.isEmpty()) {
            if (uber.peek().getRideDate() < (bolt.peek().getRideDate())){
                result.add(bolt.poll());
            } else result.add(uber.poll());
        }
        result.addAll(uber);
        result.addAll(bolt);

        return result;
    }

    @Override
    public List<Ride> getRideData(String platvorm, Date fromDate) {
        if (Objects.equals(platvorm.toUpperCase(), "UBER")) {
            return DB_UBER.stream()
                    .filter(ride -> ride.getRideDate() < fromDate.getTime())
                    .collect(Collectors.toList());
        } else if (Objects.equals(platvorm.toUpperCase(), "BOLT")) {
            return DB_BOLT.stream()
                    .filter(ride -> ride.getRideDate() < fromDate.getTime())
                    .collect(Collectors.toList());
        } else return new ArrayList<>();
    }

}
