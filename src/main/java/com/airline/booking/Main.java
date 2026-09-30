package com.airline.booking;

import com.airline.booking.abstractfactory.AirlineFactory;
import com.airline.booking.abstractfactory.AirlineProductBundle;
import com.airline.booking.abstractfactory.FactoryProvider;

public class Main {

    public static void main(String[] args) {

        String airline = args.length > 0
                ? args[0]
                : "airastana";

        AirlineFactory factory = FactoryProvider.getFactory(airline);

        AirlineProductBundle products = factory.createProductBundle();

        System.out.println("Selected airline: " + products.getAirline());
        System.out.println("Seat: " + products.getSeat().getSeatNumber());
        System.out.println("Meal: " + products.getMeal().getMealType());
        System.out.println("Baggage: " + products.getBaggage().getWeight() + " kg");
        System.out.println(
                "Products total: " + products.calculateProductsPrice()
        );
    }
}