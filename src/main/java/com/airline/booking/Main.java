package com.airline.booking;

import com.airline.booking.model.Booking;
import com.airline.booking.model.Flight;
import com.airline.booking.model.Passenger;

import com.airline.booking.products.Baggage;
import com.airline.booking.products.Meal;
import com.airline.booking.products.Seat;

import com.airline.booking.products.airastana.AirAstanaBaggage;
import com.airline.booking.products.airastana.AirAstanaMeal;
import com.airline.booking.products.airastana.AirAstanaSeat;

import com.airline.booking.products.scat.ScatBaggage;
import com.airline.booking.products.scat.ScatMeal;
import com.airline.booking.products.scat.ScatSeat;

import com.airline.booking.products.jet.JetBaggage;
import com.airline.booking.products.jet.JetMeal;
import com.airline.booking.products.jet.JetSeat;

public class Main {

    public static void main(String[] args) {

        String airline = args.length > 0
                ? args[0].toLowerCase()
                : "airastana";

        Passenger passenger = new Passenger(
                "Ansar",
                "N12345678"
        );

        Flight flight = new Flight(
                "KC101",
                "Astana",
                "Almaty",
                50000
        );

        Seat seat;
        Meal meal;
        Baggage baggage;

        if (airline.equals("airastana")) {

            seat = new AirAstanaSeat(
                    "12A",
                    "Economy",
                    3000
            );

            meal = new AirAstanaMeal(
                    "Standard",
                    5000
            );

            baggage = new AirAstanaBaggage(
                    20,
                    8000
            );

        } else if (airline.equals("scat")) {

            seat = new ScatSeat(
                    "18C",
                    "Economy",
                    2500
            );

            meal = new ScatMeal(
                    "Standard",
                    4500
            );

            baggage = new ScatBaggage(
                    20,
                    7000
            );

        } else if (airline.equals("jet")) {

            seat = new JetSeat(
                    "4A",
                    "Business",
                    3500
            );

            meal = new JetMeal(
                    "Premium",
                    5500
            );

            baggage = new JetBaggage(
                    20,
                    9000
            );

        } else {
            throw new IllegalArgumentException(
                    "Unknown airline: " + airline
            );
        }

        Booking booking = new Booking(
                "BK-1001",
                passenger,
                flight,
                seat,
                meal,
                baggage
        );

        System.out.println("=== AIRLINE BOOKING ===");
        System.out.println();

        System.out.println(
                "Booking: " + booking.getBookingNumber()
        );

        System.out.println(
                "Passenger: " + booking.getPassenger().getName()
        );

        System.out.println(
                "Flight: " + booking.getFlight().getFlightNumber()
        );

        System.out.println(
                "Route: "
                        + booking.getFlight().getOrigin()
                        + " -> "
                        + booking.getFlight().getDestination()
        );

        System.out.println(
                "Airline: " + seat.getAirline()
        );

        System.out.println(
                "Seat: "
                        + seat.getSeatNumber()
                        + " ("
                        + seat.getClassType()
                        + ")"
        );

        System.out.println(
                "Meal: " + meal.getMealType()
        );

        System.out.println(
                "Baggage: " + baggage.getWeight() + " kg"
        );

        System.out.println();

        System.out.println(
                "Total price: "
                        + booking.calculateTotalPrice()
        );
    }
}