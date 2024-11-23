package behavioral;

import domain.Vehicle;
import domain.VehicleRegistry;

// UpdateSoftwareCommand.java
public class UpdateSoftwareCommand implements Command {
    private String vehicleName;

    public UpdateSoftwareCommand(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    @Override
    public void execute() {
        Vehicle vehicle = VehicleRegistry.getInstance().getVehicle(vehicleName);
        if (vehicle != null) {
            System.out.println("Updating software for " + vehicleName + ".");
            // Perform the update (example: simulate update process)
            System.out.println(vehicleName + " software update complete.");
        } else {
            System.out.println("Vehicle not found in registry.");
        }
    }
}

