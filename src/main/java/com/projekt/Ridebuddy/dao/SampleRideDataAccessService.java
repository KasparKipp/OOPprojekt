package com.projekt.Ridebuddy.dao;

import com.projekt.Ridebuddy.model.Ride;
import org.apache.tomcat.util.digester.ArrayStack;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toCollection;

@Repository("SampleDao")
public class SampleRideDataAccessService implements RideDao{
    private static List<Ride> DB_BOLT = new ArrayList<>();
    private static List<Ride> DB_UBER = new ArrayList<>();


    @Override
    public int insertRide(String platvorm, Ride ride) {
        // Miks siin intelliJ pakub mulle .toUpperCase(Locale.Root)???
        // Kaspar palun guugelda ja õpi mis see tähendab kui sa ei tea
        if (Objects.equals(platvorm.toUpperCase(), "UBER")) {
            DB_UBER.add(ride);
        } else if (Objects.equals(platvorm.toUpperCase(), "BOLT")) {
            DB_BOLT.add(ride);
        } else return -1;
        return 1;
    }

    @Override
    public List<Ride> getRideData(LocalDateTime fromDate) {
        // Probleem selles, et praegu see meetod ei ole lihtsasti skaleeritav
        // ja toimib vaid 2 DB-ga.
        Deque<Ride> uber = DB_UBER.stream()
                .filter(ride -> ride.getRideDate().isAfter(fromDate))
                .collect(toCollection(ArrayDeque::new));
        Deque<Ride> bolt = DB_BOLT.stream()
                .filter(ride -> ride.getRideDate().isAfter(fromDate))
                .collect(toCollection(ArrayDeque::new));
        List<Ride> result = new ArrayList<>(uber.size() + bolt.size());
        while (!uber.isEmpty() && !bolt.isEmpty()) {
            if (uber.peek().getRideDate().isAfter(bolt.peek().getRideDate())){
                result.add(bolt.poll());
            } else result.add(uber.poll());
        }
        result.addAll(uber);
        result.addAll(bolt);

        return result;
    }

    @Override
    public List<Ride> getRideData(String platvorm, LocalDateTime fromDate) {
        if (Objects.equals(platvorm.toUpperCase(), "UBER")) {
            return DB_UBER.stream()
                    .filter(ride -> ride.getRideDate().isAfter(fromDate))
                    .collect(Collectors.toList());
        } else if (Objects.equals(platvorm.toUpperCase(), "BOLT")) {
            return DB_BOLT.stream()
                    .filter(ride -> ride.getRideDate().isAfter(fromDate))
                    .collect(Collectors.toList());
        } else return new ArrayList<>();
    }

}
