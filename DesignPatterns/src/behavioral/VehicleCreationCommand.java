package behavioral;

import domain.Vehicle;
import facade.VehicleCreationFacade;

public class VehicleCreationCommand implements Command {
    private VehicleCreationFacade facade;
    private String type;  // Economy, Standard, Luxury
    private String category;  // Car, Truck, Motorcycle
    private Vehicle createdVehicle;

    public VehicleCreationCommand(VehicleCreationFacade facade, String type, String category) {
        this.facade = facade;
        this.type = type;
        this.category = category;
    }

    @Override
    public void execute() {
        switch (category.toLowerCase()) {
            case "car":
                createdVehicle = createCar();
                break;
            case "truck":
                createdVehicle = createTruck();
                break;
            case "motorcycle":
                createdVehicle = createMotorcycle();
                break;
            default:
                throw new IllegalArgumentException("Unknown category: " + category);
        }
        System.out.println(type + " " + category + " created: " + createdVehicle);
    }

    private Vehicle createCar() {
        switch (type.toLowerCase()) {
            case "economy":
                return facade.createEconomyCar();
            case "standard":
                return facade.createStandardCar();
            case "luxury":
                return facade.createLuxuryCar();
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    private Vehicle createTruck() {
        switch (type.toLowerCase()) {
            case "economy":
                return facade.createEconomyTruck();
            case "standard":
                return facade.createStandardTruck();
            case "luxury":
                return facade.createLuxuryTruck();
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    private Vehicle createMotorcycle() {
        switch (type.toLowerCase()) {
            case "economy":
                return facade.createEconomyMotorcycle();
            case "standard":
                return facade.createStandardMotorcycle();
            case "luxury":
                return facade.createLuxuryMotorcycle();
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    public Vehicle getCreatedVehicle() {
        return createdVehicle;
    }
}
