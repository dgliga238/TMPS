package factory;

import models.Car;
import models.Motorcycle;
import models.Truck;
import domain.Vehicle;

public class LuxuryVehicleFactory implements VehicleCategoryFactory {
    @Override
    public Vehicle createCar() {
        return new Car("Luxury");
    }

    @Override
    public Vehicle createMotorcycle() {
        return new Motorcycle("Luxury");
    }

    @Override
    public Vehicle createTruck() {
        return new Truck("Luxury");
    }
}
