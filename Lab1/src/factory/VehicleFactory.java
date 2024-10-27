package factory;

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
