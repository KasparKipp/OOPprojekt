package com.nullekt.Ridebuddy.rides.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ride implements Comparable<Ride> {

    @Id
    private final Long rideDate;
    private final String rideAddress;
    private final double price;
    private final double cancellationFee;
    private final double tip;
    private final char currency; //What currency is used
    private final int paymentMethod; //Values specified in model.Constants
    private final int rideDistance;//in km
    private LocalDateTime timeOfPayment;

    //Konstruktor kus rideDate on long
    public Ride(Long rideDate,
                String rideAddress,
                double price,
                double cancellationFee,
                double tip,
                char currency,
                int paymentMethod,
                int rideDistance,
                LocalDateTime timeOfPayment) {
        this.rideDate = rideDate;
        this.rideAddress = rideAddress;
        this.price = price;
        this.cancellationFee = cancellationFee;
        this.tip = tip;
        this.currency = currency;
        this.paymentMethod = paymentMethod;
        this.rideDistance = rideDistance;
        this.timeOfPayment = timeOfPayment;
    }



    @Override
    public int compareTo(Ride o) {
        return rideDate.compareTo(o.getRideDate());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }


    public Long getId() {
        return rideDate;
    }
}
