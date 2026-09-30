package com.airline.booking;

import com.airline.booking.abstractfactory.AirlineFactory;
import com.airline.booking.abstractfactory.AirlineProductBundle;
import com.airline.booking.abstractfactory.FactoryProvider;
import com.airline.booking.service.BookingService;

public class Main {

    public static void main(String[] args) {

        String airline = args.length > 0
                ? args[0]
                : "airastana";

        AirlineFactory factory =
                FactoryProvider.getFactory(airline);

        BookingService bookingService =
                new BookingService(factory);

        // Operation 1: create booking products
        AirlineProductBundle products =
                bookingService.createBookingProducts();

        System.out.println("=== BOOKING ===");

        System.out.println(
                "Airline: " + products.getAirline()
        );

        System.out.println(
                "Seat: " + products.getSeat().getSeatNumber()
        );

        System.out.println(
                "Meal: " + products.getMeal().getMealType()
        );

        System.out.println(
                "Baggage: " + products.getBaggage().getWeight()
                        + " kg"
        );

        // Operation 2: calculate total price
        double totalPrice =
                bookingService.calculateTotalPrice(products);

        System.out.println(
                "Total price: " + totalPrice
        );

        // Operation 3: confirm booking
        String confirmation =
                bookingService.confirmBooking(products);

        System.out.println(confirmation);
    }
}