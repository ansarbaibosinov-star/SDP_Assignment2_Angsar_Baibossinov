package com.airline.booking.factorymethod;

public abstract class BookingCreator {

    protected abstract AirlineBooking createBooking(double totalPrice);

    public AirlineBooking processBooking(double basePrice, double serviceFee) {

        if (basePrice <= 0) {
            throw new IllegalArgumentException("Base price must be positive");
        }

        if (serviceFee < 0) {
            throw new IllegalArgumentException("Service fee cannot be negative");
        }

        double totalPrice = basePrice + serviceFee;

        AirlineBooking booking = createBooking(totalPrice);

        System.out.println("Processing booking for " + booking.getAirline());
        System.out.println("Total price: " + booking.getTotalPrice());

        return booking;
    }
}

//здесь фактори метод