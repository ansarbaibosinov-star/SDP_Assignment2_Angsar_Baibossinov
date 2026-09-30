package com.airline.booking;

import com.airline.booking.abstractfactory.AirlineFactory;
import com.airline.booking.abstractfactory.AirlineProductBundle;
import com.airline.booking.abstractfactory.AirAstanaFactory;

public class Main {

    public static void main(String[] args) {

        AirlineFactory factory = new AirAstanaFactory();

        AirlineProductBundle products =
                factory.createProductBundle();

        System.out.println("Airline: " + products.getAirline());

        System.out.println(
                "Seat: " + products.getSeat().getSeatNumber()
        );

        System.out.println(
                "Meal: " + products.getMeal().getMealType()
        );

        System.out.println(
                "Baggage: " + products.getBaggage().getWeight() + " kg"
        );

        System.out.println(
                "Products total: "
                        + products.calculateProductsPrice()
        );
    }
}