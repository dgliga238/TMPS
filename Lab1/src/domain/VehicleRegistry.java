package domain;

import java.util.HashMap;
import java.util.Map;

public class VehicleRegistry {
    private static final VehicleRegistry INSTANCE = new VehicleRegistry();
    private final Map<String, Vehicle> registry = new HashMap<>();

    private VehicleRegistry() {}

    public static VehicleRegistry getInstance() {
        return INSTANCE;
    }
    public void registerVehicle(String name, Vehicle vehicle) {
        registry.put(name, vehicle);
    }

    public Vehicle getVehicle(String name) {
        return registry.get(name);
    }
}

