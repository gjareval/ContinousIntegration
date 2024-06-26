package com.mycompany.gymmembership;

// Represents an additional feature that can be added to a membership plan
class AdditionalFeature {
    private String name;
    private double cost;

    public AdditionalFeature(String name, double cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return name + ": $" + cost;
    }
}
