package factory;

import models.Car;
import models.Motorcycle;
import models.Truck;
import domain.Vehicle;

public class StandardVehicleFactory implements VehicleCategoryFactory {
    @Override
    public Vehicle createCar() {
        return new Car("Standard");
    }

    @Override
    public Vehicle createMotorcycle() {
        return new Motorcycle("Standard");
    }

    @Override
    public Vehicle createTruck() {
        return new Truck("Standard");
    }
}