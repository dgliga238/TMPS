package adapters;

import domain.VehicleAdapter;
import models.Car;
import models.Motorcycle;

public class MotoAdapter implements VehicleAdapter {
    private Motorcycle moto;

    public MotoAdapter(Motorcycle moto) {
        this.moto = moto;
    }

    @Override
    public void drive() {
        moto.assemble();
        System.out.println("Driving " + moto.toString());
    }
}
