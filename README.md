# Airline Booking System

## Project Overview

This project is an Airline Booking System developed to demonstrate two creational design patterns:

- Factory Method
- Abstract Factory

The system supports multiple airline product families:

- Air Astana
- SCAT
- Jet
- Fly

Each airline family provides three related products:

- Seat
- Meal
- Baggage

The system allows the client to work with products through interfaces instead of directly creating concrete product classes.

---

## Technologies

- Java 17
- Maven
- JUnit 5
- IntelliJ IDEA
- Git
- Mermaid / draw.io for UML

---


Factory Method

The Factory Method pattern is used for creating airline booking objects.

The abstract BookingCreator defines the factory method:

protected abstract AirlineBooking createBooking(double totalPrice);

Concrete creators override this method:

AirAstanaBookingCreator
ScatBookingCreator
JetBookingCreator

The creator also contains business logic in processBooking().

The client does not directly create:

new AirAstanaBooking(...)
new ScatBooking(...)
new JetBooking(...)

Instead, creation is delegated to the appropriate creator.

Abstract Factory

The Abstract Factory pattern is used to create compatible airline product families.

The main factory interface is:

AirlineFactory

It provides methods for creating:

Seat
Meal
Baggage
AirlineProductBundle

Concrete factories are:

AirAstanaFactory
ScatFactory
JetFactory
FlyFactory

Each factory creates products belonging to the same airline family.

For example:

AirAstanaFactory
├── AirAstanaSeat
├── AirAstanaMeal
└── AirAstanaBaggage
Product Families
Air Astana
AirAstanaSeat
AirAstanaMeal
AirAstanaBaggage
SCAT
ScatSeat
ScatMeal
ScatBaggage
Jet
JetSeat
JetMeal
JetBaggage
Fly
FlySeat
FlyMeal
FlyBaggage

Fly is an educational fourth product family added to demonstrate system extensibility.

Runtime Factory Selection

The system selects an airline factory at runtime using FactoryProvider.

Example:

AirlineFactory factory =
FactoryProvider.getFactory("airastana");

The airline can also be provided through program arguments:

airastana
scat
jet
fly

Example:

java Main scat

The client does not need to change its business logic when another airline is selected.

Business Operations

The BookingService provides several business operations.

1. Create booking products
   createBookingProducts()

Creates a complete compatible product bundle.

2. Calculate total price
   calculateTotalPrice(products)

Calculates the total price of the selected seat, meal and baggage.

3. Confirm booking
   confirmBooking(products)

Validates the booking products and confirms the booking.

Compatibility

The Abstract Factory keeps products within the same airline family.

For example:

AirAstanaFactory
↓
AirAstanaProductBundle
↓
AirAstanaSeat
AirAstanaMeal
AirAstanaBaggage

The client normally receives the complete bundle from one factory instead of manually combining products from different families.

Bundle constructors are package-private, which prevents normal external client code from directly constructing arbitrary family bundles.

Fourth Family

The fourth family Fly was added after the original three families.

New classes include:

FlyFactory
FlySeat
FlyMeal
FlyBaggage
FlyProductBundle

The existing BookingService works with the new family without modification because it depends only on abstractions:

AirlineFactory
AirlineProductBundle
Seat
Meal
Baggage

Only the new family-specific classes and runtime selection entry were required.

Running the Project
Using Maven

Compile the project:

mvn clean compile

Run tests:

mvn test
Running the Application

The application accepts the airline as a program argument.

Examples:

airastana
scat
jet
fly

If no argument is provided, the default airline is:

airastana
Testing

The project contains automated JUnit tests for:

original airline families
fourth family
concrete product creation
product bundles
runtime factory selection
unknown airline handling
booking creation
price calculation
booking confirmation
invalid/null scenarios

Run:

mvn test
UML Diagram

The UML diagram is located in:

docs/airline-booking-uml.png

It demonstrates:

Factory Method
Abstract Factory
Product interfaces
Concrete products
Concrete factories
Creator classes
Runtime factory selection
Client and service relationships
Design Pattern Summary
Pattern	Main Classes	Purpose
Factory Method	BookingCreator	Creates airline booking objects
Abstract Factory	AirlineFactory	Creates compatible product families
Runtime Selection	FactoryProvider	Selects the required airline factory
Client/Service	BookingService	Performs booking business operations
Conclusion

The Airline Booking System demonstrates how Factory Method and Abstract Factory can be used together.

Factory Method separates the creation of airline booking objects from the main booking process.

Abstract Factory provides complete and compatible product families consisting of seats, meals and baggage.

The architecture also allows a new airline family to be added without changing the main business logic.
## Project Structure

```text
src/
├── main/
│   └── java/
│       └── com/airline/booking/
│           ├── Main.java
│           │
│           ├── factorymethod/
│           │   ├── AirlineBooking.java
│           │   ├── BookingCreator.java
│           │   ├── AirAstanaBooking.java
│           │   ├── ScatBooking.java
│           │   ├── JetBooking.java
│           │   ├── AirAstanaBookingCreator.java
│           │   ├── ScatBookingCreator.java
│           │   └── JetBookingCreator.java
│           │
│           ├── products/
│           │   ├── Seat.java
│           │   ├── Meal.java
│           │   ├── Baggage.java
│           │   ├── airastana/
│           │   ├── scat/
│           │   ├── jet/
│           │   └── fly/
│           │
│           ├── abstractfactory/
│           │   ├── AirlineFactory.java
│           │   ├── AirlineProductBundle.java
│           │   ├── AirAstanaFactory.java
│           │   ├── ScatFactory.java
│           │   ├── JetFactory.java
│           │   ├── FlyFactory.java
│           │   ├── AirAstanaProductBundle.java
│           │   ├── ScatProductBundle.java
│           │   ├── JetProductBundle.java
│           │   ├── FlyProductBundle.java
│           │   └── FactoryProvider.java
│           │
│           └── service/
│               └── BookingService.java
│
└── test/
    └── java/
        └── com/airline/booking/
            ├── factory/
            │   ├── AbstractFactoryTest.java
            │   └── FactoryProviderTest.java
            │
            └── service/
                └── BookingServiceTest.java

