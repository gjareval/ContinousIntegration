package com.mycompany.gymmembership;

import java.util.*;

// Manages the gym membership system
public class MembershipManager {
    private List<MembershipPlan> membershipPlans;
    private List<AdditionalFeature> additionalFeatures;

    public MembershipManager() {
        // Initialize membership plans
        membershipPlans = new ArrayList<>();
        membershipPlans.add(new MembershipPlan("Basic Membership", "Access during standard hours", 50.0));
        membershipPlans.add(new MembershipPlan("Premium Membership", "All-time access + Fitness classes", 80.0));
        membershipPlans.add(new MembershipPlan("Family Membership", "Discounted rate for multiple members", 120.0));

        // Initialize additional features
        additionalFeatures = new ArrayList<>();
        additionalFeatures.add(new AdditionalFeature("Personal Trainer Sessions", 30.0));
        additionalFeatures.add(new AdditionalFeature("Group Classes", 20.0));
    }

    public List<MembershipPlan> getMembershipPlans() {
        return membershipPlans;
    }

    public List<AdditionalFeature> getAdditionalFeatures() {
        return additionalFeatures;
    }

    public void displayMembershipPlans() {
        System.out.println("Gym Membership Plans:");
        for (int i = 0; i < membershipPlans.size(); i++) {
            MembershipPlan plan = membershipPlans.get(i);
            if (plan.isAvailable()) {
                System.out.println((i + 1) + ". " + plan);
            }
        }
    }

    public void displayAdditionalFeatures() {
        System.out.println("\nAdditional Features:");
        for (int i = 0; i < additionalFeatures.size(); i++) {
            System.out.println((i + 1) + ". " + additionalFeatures.get(i));
        }
    }

    public double calculateTotalCost(int planIndex, List<Integer> featureIndices) {
        MembershipPlan selectedPlan = membershipPlans.get(planIndex);
        double totalCost = selectedPlan.getBaseCost();

        // Calculate additional features cost
        for (int index : featureIndices) {
            totalCost += additionalFeatures.get(index).getCost();
        }

        // Apply discounts for group memberships
        if (featureIndices.size() >= 2) {
            totalCost *= 0.9; // 10% discount for group memberships
            System.out.println("\nYou've qualified for a 10% group membership discount!");
        }

        // Apply special offer discounts based on total cost
        if (totalCost > 200 && totalCost <= 400) {
            totalCost -= 20.0; // $20 discount for total cost over $200
            System.out.println("You've saved $20 with our special offer discount!");
        } else if (totalCost > 400) {
            totalCost -= 50.0; // $50 discount for total cost over $400
            System.out.println("You've saved $50 with our special offer discount!");
        }

        // Check if premium membership features are selected and apply surcharge
        if (planIndex == 1 || featureIndices.contains(1) || featureIndices.contains(2)) {
            totalCost *= 1.15; // 15% surcharge for premium features
            System.out.println("Premium features surcharge applied.");
        }

        return totalCost;
    }

    public boolean isValidSelection(int planIndex, List<Integer> featureIndices) {
        // Check membership plan availability
        if (planIndex < 0 || planIndex >= membershipPlans.size() || !membershipPlans.get(planIndex).isAvailable()) {
            System.out.println("Invalid membership plan selection.");
            return false;
        }

        // Check additional feature indices validity
        for (int index : featureIndices) {
            if (index < 0 || index >= additionalFeatures.size()) {
                System.out.println("Invalid additional feature selection.");
                return false;
            }
        }

        return true;
    }

    public void displayConfirmation(int planIndex, List<Integer> featureIndices, double totalCost) {
        MembershipPlan selectedPlan = membershipPlans.get(planIndex);
        System.out.println("\nMembership Plan: " + selectedPlan);

        System.out.println("Selected Additional Features:");
        for (int index : featureIndices) {
            System.out.println("- " + additionalFeatures.get(index));
        }

        System.out.println("Total Cost: $" + totalCost);
    }
}
