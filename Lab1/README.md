# Creational Design Patterns


### Author: Gliga Daniela, FAF-223


## Objectives:
1. Study and understand the Creational Design Patterns.
2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.
3. Use some creational design patterns for object instantiation in a sample project.


## Main Task:
1. Choose an OO programming language and a suitable IDE or Editor (No frameworks/libs/engines allowed).

2. Select a domain area for the sample project.

3. Define the main involved classes and think about what instantiation mechanisms are needed.

4. Based on the previous point, implement atleast 3 creational design patterns in your project.

## Used Design Patterns:
- **Abstract Factory**
- **Factory Method**
- **Singleton**

## Implementation
In order to create a project for implementing some creational patterns, I have chosen the manufacturing vehicles area. 
In this project the main classes will be `Vehicle` interface which will be implemented by `Car` , `Motorcycle` and `Truck` classes.
Another important class in this project is `VehicleCategoryFactory` interface, which will be implemented by `StandardVehicleFactory`, `EconomyVehicleFactory` and `LuxuryVehicleFactory` classes.
Creating this structure we obtain **Abstract Factory** design pattern. In this way, when creating a new object , we are not limited neither by which object to create (car, motorcycle or truck) nor by its type (economy, standard, or luxury).
```java
public interface VehicleCategoryFactory {
    Vehicle createCar();
    Vehicle createMotorcycle();
    Vehicle createTruck();
}

public interface Vehicle {
    void assemble();
    String getModel();
    String getCategory();
}
```
One more class present in this system is `VehicleFactory`. It deals with assigning a different factory based on the category (economy, standard or luxury).
The creation of this class means using **Factory Method**. Using it , we are ensured that for the client will be easier to use the manufacturing system, since he does not have to know every class by name.
```java
public class VehicleFactory {
    public static VehicleCategoryFactory getFactory(String category) {
        switch (category.toLowerCase()) {
            case "economy":
                return new EconomyVehicleFactory();
            case "standard":
                return new StandardVehicleFactory();
            case "luxury":
                return new LuxuryVehicleFactory();
            default:
                throw new IllegalArgumentException("Unknown category: " + category);
        }
    }
}
```




Another important class is `VehicleRegistry`. It is responsible for managing data about all the vehicles created inside the system. By implementing this class, teh **Singleton** pattern is used.

## Conclusions
In conclusion, the use of creational design patterns which I have implemented: Abstarct Factory, Factory Method and Singleton makes the system more flexible and easier to interact with. 
Speaking preciesely about this project, implementing Abstract Factory the client can easily create different type of vehicles in different styles. It is much easier just to instantiate object than creating every type of vehicle in every style. Structuring the design of the system in this way saves time and other precious resources.
Factory method implemented in Vehicle Factory brings also a great advantage, which makes the system more flexible and more types of vehicles now are easier to add in the system. 
A class which deals with the management of the whole system is crucial when interacting with it, therefore implementing Singleton is a great choice for a clear structure.
In general, creational design patterns offers an easy and clear approach when designing projects when several things should be created in different ways.
