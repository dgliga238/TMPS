package client;

import adapters.CarAdapter;
import decorators.GpsDecorator;
import domain.Vehicle;
import domain.VehicleAdapter;
import domain.VehicleRegistry;
import facade.VehicleCreationFacade;
import factory.VehicleCategoryFactory;
import factory.VehicleFactory;
import models.Car;
import models.Truck;

// Main.java (Client)
public class Main {
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
}
