package com.projekt.Ridebuddy.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class Ride implements Comparable<Ride> {
    private final LocalDateTime rideDate;
    private final String rideAddress;
    private final double price;
    private final double cancellationFee;
    private final double tip;
    private final char currency; //What currency is used
    private final int paymentMethod; //Values specified in model.Constants
    private final int rideDistance;//in km

    public Ride(@JsonProperty("rideDate") LocalDateTime rideDate,
                @JsonProperty("rideAddress") String rideAddress,
                @JsonProperty("price") double price,
                @JsonProperty("cancellationFee") double cancellationFee,
                @JsonProperty("tip") double tip,
                @JsonProperty("currency") char currency,
                @JsonProperty("paymentMethod") int paymentMethod,
                @JsonProperty("rideDistance") int rideDistance) {
        this.rideDate = rideDate;
        this.rideAddress = rideAddress;
        this.price = price;
        this.cancellationFee = cancellationFee;
        this.tip = tip;
        this.currency = currency;
        this.paymentMethod = paymentMethod;
        this.rideDistance = rideDistance;
    }


    public LocalDateTime getRideDate() {
        return rideDate;
    }

    public String getRideAddress() {
        return rideAddress;
    }

    public double getPrice() {
        return price;
    }

    public double getCancellationFee() {
        return cancellationFee;
    }

    public double getTip() {
        return tip;
    }

    public char getCurrency() {
        return currency;
    }

    public int getPaymentMethod() {
        return paymentMethod;
    }

    public int getRideDistance() {
        return rideDistance;
    }

    @Override
    public int compareTo(Ride o) {
        return this.getRideDate().compareTo(o.getRideDate());
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
