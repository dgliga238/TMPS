package adapters;
import domain.VehicleAdapter;

import domain.VehicleRegistry;
import models.Car;

public class CarAdapter implements VehicleAdapter {
    private Car car;

    public CarAdapter(Car car) {
        this.car = car;
    }

    @Override
    public void drive() {
        car.assemble();
    }
}
