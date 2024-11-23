package facade;

import domain.Vehicle;
import factory.EconomyVehicleFactory;
import factory.LuxuryVehicleFactory;
import factory.StandardVehicleFactory;
import factory.VehicleCategoryFactory;

// VehicleCreationFacade.java
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

    public Vehicle createStandardTruck() {
        return standardFactory.createTruck();
    }

    public Vehicle createLuxuryTruck() {
        return luxuryFactory.createTruck();
    }

    public Vehicle createEconomyMotorcycle() {
        return economyFactory.createMotorcycle();
    }

    public Vehicle createStandardMotorcycle() {
        return standardFactory.createMotorcycle();
    }

    public Vehicle createLuxuryMotorcycle() {
        return luxuryFactory.createMotorcycle();
    }
}
