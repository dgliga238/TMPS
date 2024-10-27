package models;

import domain.Vehicle;

public class Motorcycle implements Vehicle {
    private final String model = "Motorcycle";
    private final String category;

    public Motorcycle(String category) {
        this.category = category;
    }

    @Override
    public void assemble() {
        System.out.println("Assembling a " + category + " Motorcycle.");
    }

    @Override
    public String getModel() {
        return model;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return category + " " + model;
    }
}
