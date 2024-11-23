package decorators;
import domain.Vehicle;

public abstract class VehicleDecorator implements Vehicle {
    protected Vehicle decoratedVehicle;

    public VehicleDecorator(Vehicle vehicle) {
        this.decoratedVehicle = vehicle;
    }

    public void assemble() {
        decoratedVehicle.assemble();
    }
}