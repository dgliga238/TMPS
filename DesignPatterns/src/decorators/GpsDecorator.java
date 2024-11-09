package decorators;

import domain.Vehicle;

public class GpsDecorator extends VehicleDecorator {
    public GpsDecorator(Vehicle vehicle) {
        super(vehicle);
    }

    public void assemble() {
        super.assemble();
        System.out.println("Adding GPS feature to the vehicle");
    }
}
