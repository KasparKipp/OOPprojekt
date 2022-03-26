package com.projekt.rides.model;

import java.time.LocalDateTime;

public class Ride implements Comparable<Ride>{
    private final LocalDateTime date;
    private final String address;
    private final double price;
    private final double cancellationFee;
    private final double tip;
    private final char valuuta; //What currency is used
    private final boolean paymentMethod; //True if cash, else false
    private final int rideDistance;//in km

    public Ride(LocalDateTime date,
                String address,
                double price,
                double cancellationFee,
                double tip, char valuuta,
                boolean paymentMethod,
                int rideDistance) {
        this.date = date;
        this.address = address;
        this.price = price;
        this.cancellationFee = cancellationFee;
        this.tip = tip;
        this.valuuta = valuuta;
        this.paymentMethod = paymentMethod;
        this.rideDistance = rideDistance;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getAddress() {
        return address;
    }

    public double getRideIncome() {
        return price + cancellationFee + tip;
    }

    public int getRideDistance() {
        return rideDistance;
    }

    @Override
    public int compareTo(Ride o) {
        return this.getDate().compareTo(o.getDate());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
