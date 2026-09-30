package com.airline.booking.service;

import com.airline.booking.abstractfactory.AirlineFactory;
import com.airline.booking.abstractfactory.AirlineProductBundle;
import com.airline.booking.products.Baggage;
import com.airline.booking.products.Meal;
import com.airline.booking.products.Seat;

public class BookingService {

    private final AirlineFactory factory;

    public BookingService(AirlineFactory factory) {
        this.factory = factory;
    }

    // Business Operation 1:
    // Create a complete set of products for a booking
    public AirlineProductBundle createBookingProducts() {

        return factory.createProductBundle();
    }

    // Business Operation 2:
    // Calculate the total price of selected products
    public double calculateTotalPrice(AirlineProductBundle products) {

        if (products == null) {
            throw new IllegalArgumentException(
                    "Product bundle cannot be null"
            );
        }

        return products.calculateProductsPrice();
    }

    // Business Operation 3:
    // Confirm booking after checking all required products
    public String confirmBooking(AirlineProductBundle products) {

        if (products == null) {
            throw new IllegalArgumentException(
                    "Product bundle cannot be null"
            );
        }

        Seat seat = products.getSeat();
        Meal meal = products.getMeal();
        Baggage baggage = products.getBaggage();

        if (seat == null) {
            throw new IllegalStateException(
                    "Seat must be selected"
            );
        }

        if (meal == null) {
            throw new IllegalStateException(
                    "Meal must be selected"
            );
        }

        if (baggage == null) {
            throw new IllegalStateException(
                    "Baggage must be selected"
            );
        }

        return "Booking confirmed for " + products.getAirline()
                + ". Total price: "
                + calculateTotalPrice(products);
    }
}