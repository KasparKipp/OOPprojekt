package com.projekt.Ridebuddy.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RideDateFormater {
    private final String timeToReturn;

    public RideDateFormater(@JsonProperty("sinceThisTime") String timeToReturn) {
        this.timeToReturn = timeToReturn;
    }

    public LocalDateTime getTimeToReturn() {
        return LocalDateTime.parse(timeToReturn, DateTimeFormatter.ISO_LOCAL_DATE_TIME);
    }
}
