package models;

import domain.Vehicle;

public class Car implements Vehicle {
    private final String model = "Car";
    private final String category;

    public Car(String category) {
        this.category = category;
    }

    @Override
    public void assemble() {
        System.out.println("Assembling a " + category + " Car.");
    }


    @Override
    public String toString() {
        return category + " " + model;
    }

}
