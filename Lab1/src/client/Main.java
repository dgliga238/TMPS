package client;

import domain.Vehicle;
import domain.VehicleRegistry;
import factory.VehicleCategoryFactory;
import factory.VehicleFactory;
import models.Car;
import models.Truck;

public class Main {
    public static void main(String[] args) {

        Vehicle myCar = new Car("luxury");
        myCar.assemble();
        System.out.println("Model: " + myCar.getModel());
        System.out.println("Category: " + myCar.getCategory());
        System.out.println(myCar.toString());

        Vehicle myTruck = new Truck("economy");
        myTruck.assemble();
        System.out.println("Model: " + myTruck.getModel());
        System.out.println("Category: " + myTruck.getCategory());
        System.out.println(myTruck.toString());

        Vehicle myMoto = new Truck("standard");
        myTruck.assemble();
        System.out.println("Model: " + myMoto.getModel());
        System.out.println("Category: " + myMoto.getCategory());
        System.out.println(myMoto.toString());

    }
}
