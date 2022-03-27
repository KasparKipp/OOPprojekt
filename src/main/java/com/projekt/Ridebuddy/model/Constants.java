package com.projekt.Ridebuddy.model;

public class Constants {

    /**
     * Constants for payment methods
     */
    public static final int TRANSACTION_CASH = 69;
    public static final int TRANSACTION_APP_PAYMENT = 70;
    public static final int TRANSACTION_CARD = 71;

    private Constants() {
        throw new IllegalStateException("Instantiation not allowed.");
    }
}
