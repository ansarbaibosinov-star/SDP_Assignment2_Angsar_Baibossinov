package com.airline.booking.model;

public class Passenger {

    private final String name;
    private final String passportNumber;

    public Passenger(String name, String passportNumber) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Passenger name cannot be empty");
        }

        if (passportNumber == null || passportNumber.isBlank()) {
            throw new IllegalArgumentException("Passport number cannot be empty");
        }

        this.name = name;
        this.passportNumber = passportNumber;
    }

    public String getName() {
        return name;
    }

    public String getPassportNumber() {
        return passportNumber;
    }
}