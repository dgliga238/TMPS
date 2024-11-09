package client;

import domain.Vehicle;
import domain.VehicleRegistry;
import facade.VehicleCreationFacade;
import factory.VehicleCategoryFactory;
import factory.VehicleFactory;
import models.Car;
import models.Truck;

// Main.java (Client)
public class Main {
    public static void main(String[] args) {
        // Instantiate the VehicleCreationFacade to simplify vehicle creation
        VehicleCreationFacade vehicleFacade = new VehicleCreationFacade();

        // Create different types of vehicles in various categories using the facade
        Vehicle economyCar = vehicleFacade.createEconomyCar();
        Vehicle standardTruck = vehicleFacade.createStandardTruck();
        Vehicle luxuryMotorcycle = vehicleFacade.createLuxuryMotorcycle();

        // Assemble the vehicles
        System.out.println("Assembling vehicles:");
        economyCar.assemble();         // Output: Assembling a Car (Economy)
        standardTruck.assemble();      // Output: Assembling a Truck (Standard)
        luxuryMotorcycle.assemble();   // Output: Assembling a Motorcycle (Luxury)

        // Additional examples
        Vehicle luxuryCar = vehicleFacade.createLuxuryCar();
        Vehicle economyTruck = vehicleFacade.createEconomyTruck();
        Vehicle standardMotorcycle = vehicleFacade.createStandardMotorcycle();

        // Assemble additional vehicles
        System.out.println("\nAssembling additional vehicles:");
        luxuryCar.assemble();          // Output: Assembling a Car (Luxury)
        economyTruck.assemble();       // Output: Assembling a Truck (Economy)
        standardMotorcycle.assemble(); // Output: Assembling a Motorcycle (Standard)
    }
}
