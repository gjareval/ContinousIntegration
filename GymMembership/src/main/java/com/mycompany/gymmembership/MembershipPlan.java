package com.mycompany.gymmembership;

import java.util.*;

// Represents a membership plan with its name, benefits, cost, and availability
class MembershipPlan {
    private String name;
    private String benefits;
    private double baseCost;
    private boolean available;

    public MembershipPlan(String name, String benefits, double baseCost) {
        this.name = name;
        this.benefits = benefits;
        this.baseCost = baseCost;
        this.available = true; // By default, plans are available
    }

    public String getName() {
        return name;
    }

    public String getBenefits() {
        return benefits;
    }

    public double getBaseCost() {
        return baseCost;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return name + " - " + benefits + ": $" + baseCost;
    }
}
