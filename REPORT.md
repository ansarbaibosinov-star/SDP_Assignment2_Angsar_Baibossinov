# Airline Booking System
## Design Patterns Assignment 2

**Student:** Ansar Baibossinov  
**Topic:** Airline Booking System  
**Design Patterns:** Factory Method, Abstract Factory  
**Language:** Java 17  
**Build Tool:** Maven  
**Testing:** JUnit 5

---

# 1. Project Overview

The project is an Airline Booking System designed to demonstrate the use of the Factory Method and Abstract Factory design patterns.

The system supports four airline product families:

- Air Astana
- SCAT
- Jet
- Fly

Each airline family provides three related product types:

- Seat
- Meal
- Baggage

The main goal of the project is to separate object creation from business logic and make the system easier to extend with new airline families.

---

# 2. Domain Model

The system contains three main product types.

## Seat

The `Seat` interface represents a passenger seat.

It provides:

```java
String getSeatNumber();
String getClassType();
double getPrice();
```
Different airline families provide their own seat implementations.

Examples:

AirAstanaSeat
ScatSeat
JetSeat
FlySeat
Meal

The Meal interface represents an onboard meal.

It provides:

String getMealType();
double getPrice();

Concrete implementations are:

AirAstanaMeal
ScatMeal
JetMeal
FlyMeal
Baggage

The Baggage interface represents passenger baggage.

It provides:

int getWeight();
double getPrice();

Concrete implementations are:

AirAstanaBaggage
ScatBaggage
JetBaggage
FlyBaggage
3. Part A — Initial Implementation Without Factories

The initial version of the system was designed without using Factory Method or Abstract Factory.

The client would need to directly create concrete classes.

For example:

AirAstanaSeat seat =
new AirAstanaSeat("12A", "Economy", 3000);

AirAstanaMeal meal =
new AirAstanaMeal("Standard", 5000);

AirAstanaBaggage baggage =
new AirAstanaBaggage(20, 8000);

This approach creates several design problems.

Problem 1 — Tight Coupling

The client directly depends on concrete classes.

For example:

new AirAstanaSeat(...)

The client therefore knows which concrete airline class must be created.

Problem 2 — Difficult Extension

If another airline is added, the client code must be modified to create the new concrete classes.

For example:

new FlySeat(...)
new FlyMeal(...)
new FlyBaggage(...)

This makes the system harder to maintain.

Problem 3 — Product Family Mixing

When products are created manually, it becomes easier to accidentally combine products from different airline families.

For example:

AirAstanaSeat
+
JetMeal
+
ScatBaggage

Such a combination does not represent one consistent airline product family.

The factory-based design solves this problem by creating related products through the same factory.

4. Part B — Factory Method

The Factory Method pattern is used for creating airline booking objects.

The main product interface is:

AirlineBooking

It is implemented by:

AirAstanaBooking
ScatBooking
JetBooking

The abstract creator is:

BookingCreator

It defines the factory method:

protected abstract AirlineBooking createBooking(double totalPrice);

Concrete creators are:

AirAstanaBookingCreator
ScatBookingCreator
JetBookingCreator

Each concrete creator creates the corresponding booking product.

Creator Business Logic

The Factory Method is not used only as a simple replacement for new.

BookingCreator contains business logic:

public AirlineBooking processBooking(
double basePrice,
double serviceFee)

The method:

Validates the base price.
Validates the service fee.
Calculates the total price.
Calls the Factory Method.
Processes the created booking.

Conceptually:

processBooking()
|
v
validate input
|
v
calculate total price
|
v
createBooking()
|
v
AirlineBooking

This makes the Factory Method meaningful because the Creator controls part of the booking process while subclasses decide which concrete booking object is created.

5. Why Factory Method Instead of a Static Factory?

A static factory could contain conditional logic such as:

if (airline.equals("airastana")) {
return new AirAstanaBooking(...);
}

However, that would put all concrete creation decisions into one static method.

With Factory Method:

BookingCreator
|
+-- AirAstanaBookingCreator
|
+-- ScatBookingCreator
|
+-- JetBookingCreator

Each subclass provides its own implementation of:

createBooking()

The Creator can also contain reusable business logic.

Therefore, object creation is delegated to subclasses while the general booking process remains in the base Creator.

6. Part C — Abstract Factory

The Abstract Factory pattern is used for creating related airline product families.

The main factory interface is:

AirlineFactory

It provides methods:

Seat createSeat();

Meal createMeal();

Baggage createBaggage();

AirlineProductBundle createProductBundle();

The concrete factories are:

AirAstanaFactory
ScatFactory
JetFactory
FlyFactory
7. Product Families

Each concrete factory creates products from the same airline family.

Air Astana
AirAstanaFactory
|
+-- AirAstanaSeat
+-- AirAstanaMeal
+-- AirAstanaBaggage
SCAT
ScatFactory
|
+-- ScatSeat
+-- ScatMeal
+-- ScatBaggage
Jet
JetFactory
|
+-- JetSeat
+-- JetMeal
+-- JetBaggage
Fly
FlyFactory
|
+-- FlySeat
+-- FlyMeal
+-- FlyBaggage

There are therefore at least 12 concrete products in the final implementation.

8. Product Bundle

The project also uses:

AirlineProductBundle

The bundle contains:

Seat seat;
Meal meal;
Baggage baggage;

The interface provides:

Seat getSeat();

Meal getMeal();

Baggage getBaggage();

String getAirline();

double calculateProductsPrice();

Each airline has its own bundle:

AirAstanaProductBundle
ScatProductBundle
JetProductBundle
FlyProductBundle

The bundle represents a complete set of products created for one airline family.

9. Part D — Product Compatibility

The system is designed so that normal client code does not manually construct arbitrary product bundles.

A complete product bundle is created through one AirlineFactory.

For example:

AirAstanaFactory
|
v
AirAstanaProductBundle
|
+-- AirAstanaSeat
+-- AirAstanaMeal
+-- AirAstanaBaggage

The bundle constructors are package-private, so normal external client code cannot directly construct a bundle with arbitrary products.

The client therefore normally obtains a complete compatible bundle from one factory.

This reduces the possibility of accidental combinations such as:

AirAstanaSeat
+
JetMeal
+
ScatBaggage
10. Part E — Runtime Factory Selection

The airline family is selected at runtime using:

FactoryProvider

The method is:

public static AirlineFactory getFactory(String airline)

Supported values are:

airastana
scat
jet
fly

Example:

AirlineFactory factory =
FactoryProvider.getFactory("airastana");

The application also supports command-line arguments.

Example:

scat

The client does not need to instantiate:

new AirAstanaFactory()

or:

new JetFactory()

in its business logic.

Instead, the runtime selection is performed by FactoryProvider.

11. Part F — Business Operations

The project contains three meaningful business operations.

Operation 1 — Create Booking Products
createBookingProducts()

The method creates a complete set of products through the selected airline factory.

Operation 2 — Calculate Total Price
calculateTotalPrice(products)

The method calculates the total price of:

Seat
+
Meal
+
Baggage

For example:

Seat price
+ Meal price
+ Baggage price
  = Total booking products price
  Operation 3 — Confirm Booking
  confirmBooking(products)

The method validates the booking bundle and confirms the booking.

It checks that:

the bundle exists;
a seat exists;
a meal exists;
baggage exists.

After validation, the system returns a booking confirmation message.

12. Part G — Adding the Fourth Family

The original implementation contained three airline families.

A fourth family named Fly was then added.

The following classes were added:

FlyFactory
FlySeat
FlyMeal
FlyBaggage
FlyProductBundle

The runtime provider was also extended to recognize:

fly

The main business logic did not need to be rewritten.

BookingService continues to work with:

AirlineFactory
AirlineProductBundle
Seat
Meal
Baggage

rather than concrete Fly classes.

This demonstrates extensibility through abstraction.

13. Files Changed for the Fourth Family

The main new files are:

src/main/java/com/airline/booking/products/fly/
├── FlySeat.java
├── FlyMeal.java
└── FlyBaggage.java

and:

src/main/java/com/airline/booking/abstractfactory/
├── FlyFactory.java
└── FlyProductBundle.java

The runtime selection was extended in:

FactoryProvider.java

The existing BookingService did not require airline-specific changes.

14. Part H — UML Diagram

The UML diagram represents both design patterns.

The Factory Method section contains:

BookingCreator
|
+-- AirAstanaBookingCreator
+-- ScatBookingCreator
+-- JetBookingCreator

and:

AirlineBooking
|
+-- AirAstanaBooking
+-- ScatBooking
+-- JetBooking

The Abstract Factory section contains:

AirlineFactory
|
+-- AirAstanaFactory
+-- ScatFactory
+-- JetFactory
+-- FlyFactory

The product interfaces are:

Seat
Meal
Baggage

The UML diagram also shows:

concrete products;
product bundles;
FactoryProvider;
BookingService;
Main;
factory-to-product relationships.

The UML diagram is stored in:

docs/airline-booking-uml.png
15. Part I — Automated Testing

The project uses JUnit 5.

The tests verify:

Air Astana factory creation;
SCAT factory creation;
Jet factory creation;
Fly factory creation;
concrete seat creation;
concrete meal creation;
concrete baggage creation;
complete product bundles;
runtime factory selection;
unknown airline handling;
booking product creation;
total price calculation;
booking confirmation;
invalid input scenarios.

The test classes are:

AbstractFactoryTest
FactoryProviderTest
BookingServiceTest

The project contains more than the required 15 automated tests.

Tests can be executed with:

mvn test
16. Negative Scenarios

The system tests invalid situations.

Unknown Airline

If an unknown airline is requested:

FactoryProvider.getFactory("unknown");

the system throws:

IllegalArgumentException
Null Product Bundle

If a null bundle is passed to the booking service:

service.calculateTotalPrice(null);

or:

service.confirmBooking(null);

the system throws:

IllegalArgumentException

These tests demonstrate defensive validation.

17. Part J — Git History

The project was developed through multiple meaningful Git commits.

The planned commit history is:

1. Create initial airline booking domain without factories
2. Add airline booking product abstractions
3. Introduce Factory Method for airline bookings
4. Introduce Abstract Factory for airline product families
5. Enforce airline product family compatibility
6. Add runtime airline factory selection
7. Implement airline booking business operations
8. Add fourth Fly product family
9. Add automated factory and booking tests
10. Add Factory Method and Abstract Factory UML
11. Add project documentation and design pattern overview

The commits represent separate stages of development instead of one final commit.

18. Client Independence

The client code works through abstractions.

For example:

AirlineFactory factory =
FactoryProvider.getFactory(airline);

BookingService bookingService =
new BookingService(factory);

The BookingService does not contain code such as:

new AirAstanaSeat(...)
new ScatMeal(...)
new JetBaggage(...)

Instead, it receives an abstract factory and works with interfaces.

This reduces coupling between business logic and concrete product classes.

19. Combined Pattern Architecture

The two patterns solve different creation problems.

Factory Method

Factory Method is responsible for creating an individual airline booking object.

BookingCreator
|
v
createBooking()
|
v
AirlineBooking
Abstract Factory

Abstract Factory is responsible for creating a family of related products.

AirlineFactory
|
+-- Seat
+-- Meal
+-- Baggage
+-- ProductBundle

The patterns can therefore work together in the same application.

20. Conclusion

The Airline Booking System demonstrates the practical use of Factory Method and Abstract Factory.

Factory Method separates the creation of individual booking objects from the general booking process.

Abstract Factory separates the creation of related airline product families from the client.

The system supports four airline families and three product types per family.

Runtime factory selection allows the airline to be selected without changing the business logic.

The addition of the fourth Fly family demonstrates that the architecture can be extended using new concrete products and a new factory while keeping the main business service independent from concrete airline classes.

The final implementation also contains automated tests, UML documentation, runtime selection and meaningful Git history.


