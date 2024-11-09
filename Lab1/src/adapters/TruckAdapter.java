package adapters;

import domain.VehicleAdapter;
import domain.VehicleRegistry;
import models.Truck;

public class TruckAdapter implements VehicleAdapter {
    private Truck truck;

    public TruckAdapter(Truck truck) {
        this.truck = truck;
    }

    @Override
    public void drive() {
        truck.assemble();
    }
}