package factory;

import domain.Vehicle;

public interface VehicleCategoryFactory {
    Vehicle createCar();
    Vehicle createMotorcycle();
    Vehicle createTruck();
}

