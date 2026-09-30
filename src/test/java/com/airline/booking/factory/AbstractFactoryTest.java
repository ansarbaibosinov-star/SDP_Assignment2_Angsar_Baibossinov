package com.airline.booking.factory;

import com.airline.booking.abstractfactory.AirlineFactory;
import com.airline.booking.abstractfactory.AirlineProductBundle;
import com.airline.booking.abstractfactory.AirAstanaFactory;
import com.airline.booking.abstractfactory.ScatFactory;
import com.airline.booking.abstractfactory.JetFactory;
import com.airline.booking.abstractfactory.FlyFactory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbstractFactoryTest {

    @Test
    void airAstanaFactoryCreatesCorrectSeat() {
        AirlineFactory factory = new AirAstanaFactory();

        AirlineProductBundle bundle = factory.createProductBundle();

        assertEquals("12A", bundle.getSeat().getSeatNumber());
    }

    @Test
    void airAstanaFactoryCreatesCorrectMeal() {
        AirlineFactory factory = new AirAstanaFactory();

        AirlineProductBundle bundle = factory.createProductBundle();

        assertEquals("Standard", bundle.getMeal().getMealType());
    }

    @Test
    void airAstanaFactoryCreatesCorrectBaggage() {
        AirlineFactory factory = new AirAstanaFactory();

        AirlineProductBundle bundle = factory.createProductBundle();

        assertEquals(20, bundle.getBaggage().getWeight());
    }

    @Test
    void scatFactoryCreatesCorrectSeat() {
        AirlineFactory factory = new ScatFactory();

        AirlineProductBundle bundle = factory.createProductBundle();

        assertEquals("18C", bundle.getSeat().getSeatNumber());
    }

    @Test
    void scatFactoryCreatesCorrectMeal() {
        AirlineFactory factory = new ScatFactory();

        AirlineProductBundle bundle = factory.createProductBundle();

        assertEquals("Standard", bundle.getMeal().getMealType());
    }

    @Test
    void scatFactoryCreatesCorrectBaggage() {
        AirlineFactory factory = new ScatFactory();

        AirlineProductBundle bundle = factory.createProductBundle();

        assertEquals(20, bundle.getBaggage().getWeight());
    }

    @Test
    void jetFactoryCreatesCorrectSeat() {
        AirlineFactory factory = new JetFactory();

        AirlineProductBundle bundle = factory.createProductBundle();

        assertEquals("4A", bundle.getSeat().getSeatNumber());
    }

    @Test
    void jetFactoryCreatesCorrectMeal() {
        AirlineFactory factory = new JetFactory();

        AirlineProductBundle bundle = factory.createProductBundle();

        assertEquals("Premium", bundle.getMeal().getMealType());
    }

    @Test
    void jetFactoryCreatesCorrectBaggage() {
        AirlineFactory factory = new JetFactory();

        AirlineProductBundle bundle = factory.createProductBundle();

        assertEquals(20, bundle.getBaggage().getWeight());
    }

    @Test
    void flyFactoryCreatesCorrectSeat() {
        AirlineFactory factory = new FlyFactory();

        AirlineProductBundle bundle = factory.createProductBundle();

        assertEquals("7B", bundle.getSeat().getSeatNumber());
    }

    @Test
    void flyFactoryCreatesCorrectMeal() {
        AirlineFactory factory = new FlyFactory();

        AirlineProductBundle bundle = factory.createProductBundle();

        assertEquals("Standard", bundle.getMeal().getMealType());
    }

    @Test
    void flyFactoryCreatesCorrectBaggage() {
        AirlineFactory factory = new FlyFactory();

        AirlineProductBundle bundle = factory.createProductBundle();

        assertEquals(20, bundle.getBaggage().getWeight());
    }
    @Test
    void airAstanaBundleContainsAllProducts() {
        AirlineFactory factory = new AirAstanaFactory();

        AirlineProductBundle bundle = factory.createProductBundle();

        assertNotNull(bundle.getSeat());
        assertNotNull(bundle.getMeal());
        assertNotNull(bundle.getBaggage());
    }

    @Test
    void scatBundleContainsAllProducts() {
        AirlineFactory factory = new ScatFactory();

        AirlineProductBundle bundle = factory.createProductBundle();

        assertNotNull(bundle.getSeat());
        assertNotNull(bundle.getMeal());
        assertNotNull(bundle.getBaggage());
    }

    @Test
    void jetBundleContainsAllProducts() {
        AirlineFactory factory = new JetFactory();

        AirlineProductBundle bundle = factory.createProductBundle();

        assertNotNull(bundle.getSeat());
        assertNotNull(bundle.getMeal());
        assertNotNull(bundle.getBaggage());
    }

    @Test
    void flyBundleContainsAllProducts() {
        AirlineFactory factory = new FlyFactory();

        AirlineProductBundle bundle = factory.createProductBundle();

        assertNotNull(bundle.getSeat());
        assertNotNull(bundle.getMeal());
        assertNotNull(bundle.getBaggage());
    }
}