package com.airline.booking.model;

public class Flight {

    private final String flightNumber;
    private final String origin;
    private final String destination;
    private final double basePrice;

    public Flight(
            String flightNumber,
            String origin,
            String destination,
            double basePrice
    ) {
        if (flightNumber == null || flightNumber.isBlank()) {
            throw new IllegalArgumentException("Flight number cannot be empty");
        }

        if (origin == null || origin.isBlank()) {
            throw new IllegalArgumentException("Origin cannot be empty");
        }

        if (destination == null || destination.isBlank()) {
            throw new IllegalArgumentException("Destination cannot be empty");
        }

        if (basePrice <= 0) {
            throw new IllegalArgumentException("Base price must be positive");
        }

        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.basePrice = basePrice;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public double getBasePrice() {
        return basePrice;
    }
}