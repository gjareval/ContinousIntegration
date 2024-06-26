package com.mycompany.gymmembership;


import java.util.*;

public class GymMembershipApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MembershipManager manager = new MembershipManager();

        // Display membership plans
        manager.displayMembershipPlans();

        // Select membership plan
        System.out.print("\nSelect a membership plan (1-" + manager.getMembershipPlans().size() + "): ");
        int planIndex = scanner.nextInt() - 1;
        scanner.nextLine(); // Consume newline

        // Validate membership plan selection
        if (planIndex < 0 || planIndex >= manager.getMembershipPlans().size()) {
            System.out.println("Invalid membership plan selection.");
            return;
        }

        // Display additional features
        manager.displayAdditionalFeatures();

        // Select additional features
        List<Integer> selectedFeatures = new ArrayList<>();
        boolean addMoreFeatures = true;
        while (addMoreFeatures) {
            System.out.print("Select an additional feature (1-" + manager.getAdditionalFeatures().size() +
                             "), 0 to finish: ");
            int featureIndex = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (featureIndex == 0) {
                addMoreFeatures = false;
            } else if (featureIndex < 1 || featureIndex > manager.getAdditionalFeatures().size()) {
                System.out.println("Invalid additional feature selection.");
            } else {
                selectedFeatures.add(featureIndex - 1);
            }
        }

        // Validate additional feature selections
        if (!manager.isValidSelection(planIndex, selectedFeatures)) {
            System.out.println("Invalid selection.");
            return;
        }

        // Calculate total cost
        double totalCost = manager.calculateTotalCost(planIndex, selectedFeatures);

        // Display confirmation and final cost
        manager.displayConfirmation(planIndex, selectedFeatures, totalCost);

        // Offer to confirm or cancel
        System.out.print("\nConfirm membership (yes/no)? ");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if (confirmation.equals("yes")) {
            System.out.println("Total Cost: $" + totalCost + " confirmed.");
        } else {
            System.out.println("Membership selection canceled.");
        }

        scanner.close();
    }
}
