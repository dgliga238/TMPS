# Structural Design Patterns


### Author: Gliga Daniela, FAF-223


## Objectives:
1. Study and understand the Structural Design Patterns.
2. As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.
3. Implement some additional functionalities using structural design patterns.


## Main Task:
1. By extending your project, implement atleast 3 structural design patterns in your project.
- The implemented design pattern should help to perform the tasks involved in your system.
- The object creation mechanisms/patterns can now be buried into the functionalities instead of using them into the client.
- There should only be one client for the whole system.

2. Keep your files grouped (into packages/directories) by their responsibilities.

3. Document your work in a separate markdown file.


## Used Design Patterns:
- **Adapter**
- **Decorator**
- **Facade**

## Theory
Structural design patterns are a category of design patterns that focus on how objects and classes are composed to form larger structures.
These patterns simplify the design by defining ways to create objects into larger structures while keeping them flexible and efficient.
The goal is to make relationships between components more simple, making the system more scalable and maintainable.
- **Adapter:** This pattern allows incompatible interfaces to work together by converting one interface to another. It enables classes to interact without modifying their original code.
- **Decorator:** The Decorator pattern lets you add behavior to an object dynamically without affecting other objects. It wraps the object with additional functionality, enhancing its capabilities.
- **Facade:** This pattern provides a simplified interface to a complex subsystem. It hides the complexity of multiple classes or components and offers a single unified interface to the client.

## Implementation
For adding more functionalities using structural patterns, I have chosen to use adapter pattern. 
Firstly, to achieve the structure of this pattern, I have created the interface `VehicleAdapter`, which has a simple method drive(). It is used to make abstraction of the type of car which will be driven.
```java
public interface VehicleAdapter {
    void drive();
}
```
Further, I have implemented concrete adapters: `CarAdapter`, `MotoAdapter` and `TruckAdapter`. For each type of vehicle , this drive() method was implemented in in the correspponding adapter class. 
In this way the client can interact with drive() method no matter what type of vehicle is used. 
```java
public class CarAdapter implements VehicleAdapter {
    private Car car;

    public CarAdapter(Car car) {
        this.car = car;
    }

    @Override
    public void drive() {
        car.assemble();
        System.out.println("Driving " + car.toString());
    }
}
```
In the same way two more concrete adapters were implemented, one for trucks and another for motorcycles.
Building this structure offers a way to work with different type of vehicles ( in my case it is just drive).

To add behaviour dynamilcally to some objects , I have chosen to use decorator pattern. For implementing this patten I have created an abstract `VehicleDecorator` class which implements `Vehicle` interface, which was already present. 
```java
public abstract class VehicleDecorator implements Vehicle {
    protected Vehicle decoratedVehicle;

    public VehicleDecorator(Vehicle vehicle) {
        this.decoratedVehicle = vehicle;
    }

    public void assemble() {
        decoratedVehicle.assemble();
    }
}
```
To add a new functioality I have addded a concrte decorator, in my case `GpsDecorator` ehich extends the functionalities of `VehicleDecorator`.
```java
public class GpsDecorator extends VehicleDecorator {
    public GpsDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public void assemble() {
        super.assemble();
        System.out.println("Adding GPS feature to the vehicle");
    }
}
```
Building this structure allows the system to add different functionalities, in this case Gps , inside the system without affecting the components themselves.

The last implemented pattern is Facade Pattern. It is done in `VehicleCreationFacade` class. The main goal was to simplify the interaction of the client with system.
```java
public class VehicleCreationFacade {
    private VehicleCategoryFactory economyFactory = new EconomyVehicleFactory();
    private VehicleCategoryFactory standardFactory = new StandardVehicleFactory();
    private VehicleCategoryFactory luxuryFactory = new LuxuryVehicleFactory();

    public Vehicle createEconomyCar() {
        return economyFactory.createCar();
    }

    public Vehicle createStandardCar() {
        return standardFactory.createCar();
    }

    public Vehicle createLuxuryCar() {
        return luxuryFactory.createCar();
    }

    public Vehicle createEconomyTruck() {
        return economyFactory.createTruck();
    }
    ...
    }
}
```
Instead of the client needing to know how to instantiate specific vehicle factories for each category and type of vehicle.

How all these structural patterns behaves can be seen while using them by the client:
```java
 public static void main(String[] args) {
        
        Car myCar = new Car("Toyota Corolla");
        VehicleAdapter carAdapter = new CarAdapter(myCar);
        carAdapter.drive();

        Vehicle car = new Car("Lexus");
        Vehicle decoratedCar = new GpsDecorator(car);
        decoratedCar.assemble();

        VehicleCreationFacade vehicleFacade = new VehicleCreationFacade();

        Vehicle economyCar = vehicleFacade.createEconomyCar();
        Vehicle luxuryTruck = vehicleFacade.createLuxuryTruck();
        economyCar.assemble();
        luxuryTruck.assemble();
    }
 ```
To show the Adapter Pattern, the client uses the `CarAdapter` to interact with a the Car, driving it without knowing all the internal staff and what methods, claases are used. This allows flexibility for the client to work with different vehicle types (cars, trucks, motorcycles) through their adapters.

Through the Decorator Pattern, the Gps functionality is added to a specific car, without changing anything in the car itself.

With the Facade Pattern, the creation of different types of vehicles is much simpler, and the client does not need to know the underlying information about every factory implemented.
## Conclusions

By extending the project with the Adapter, Decorator, and Facade design patterns, the system becomes more modular and flexible.
The Adapter pattern allows different vehicle types to be used by each other by providing a common interface, making it easy to extend the system with new vehicle types. 
The Decorator pattern enables dynamic addition of functionalities, like GPS, to vehicles without modifying the objects themselves. 
The Facade pattern simplifies the client’s interaction with the system by providing a unified interface for vehicle creation, making abstract the underlying processes. 
Together, these patterns improve the scalability, maintainability, and flexibility of the system, making it easier for the client to interact with and to expand as new features appear.