package factory;

import models.Car;
import models.Motorcycle;
import models.Truck;
import domain.Vehicle;

public class EconomyVehicleFactory implements VehicleCategoryFactory {
    @Override
    public Vehicle createCar() {
        return new Car("Economy");
    }

    @Override
    public Vehicle createMotorcycle() {
        return new Motorcycle("Economy");
    }

    @Override
    public Vehicle createTruck() {
        return new Truck("Economy");
    }
}
