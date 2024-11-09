package models;

import domain.Vehicle;

public class Truck implements Vehicle {
    private final String model = "Truck";
    private final String category;

    public Truck(String category) {
        this.category = category;
    }

    @Override
    public void assemble() {
        System.out.println("Assembling a " + category + " Truck.");
    }


    @Override
    public String toString() {
        return category + " " + model;
    }
}
