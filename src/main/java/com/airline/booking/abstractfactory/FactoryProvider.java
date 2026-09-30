package com.airline.booking.abstractfactory;

public class FactoryProvider {

    public static AirlineFactory getFactory(String airline) {

        return switch (airline.toLowerCase()) {

            case "airastana" -> new AirAstanaFactory();

            case "scat" -> new ScatFactory();

            case "jet" -> new JetFactory();

            case "fly" -> new FlyFactory();

            default -> throw new IllegalArgumentException(
                    "Unknown airline: " + airline
            );
        };
    }
}