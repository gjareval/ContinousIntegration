/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.mycompany.gymmembership.MembershipManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sisua
 */
public class MembershipManagerTest {
    
    private MembershipManager manager;

    @BeforeEach
    public void setUp() {
        manager = new MembershipManager();
    }

    @Test
    public void testCalculateTotalCostBasicNoFeatures() {
        List<Integer> features = new ArrayList<>();
        double totalCost = manager.calculateTotalCost(0, features); // Basic Membership
        assertEquals(50.0, totalCost);
    }

    @Test
    public void testCalculateTotalCostPremiumWithFeatures() {
        List<Integer> features = new ArrayList<>();
        features.add(0); // Personal Trainer Sessions
        features.add(1); // Group Classes
        double totalCost = manager.calculateTotalCost(1, features); // Premium Membership
        assertTrue(totalCost > 0); // Add your own validation logic based on current discount rules
    }

    @Test
    public void testCalculateTotalCostWithDiscount() {
        List<Integer> features = new ArrayList<>();
        features.add(0); // Personal Trainer Sessions
        features.add(1); // Group Classes
        double totalCost = manager.calculateTotalCost(2, features); // Family Membership
        assertTrue(totalCost > 0); // Add your own validation logic based on current discount rules
    }

    @Test
    public void testIsValidSelectionValid() {
        List<Integer> features = new ArrayList<>();
        features.add(0); // Personal Trainer Sessions
        assertTrue(manager.isValidSelection(0, features)); // Basic Membership
    }

    @Test
    public void testIsValidSelectionInvalidPlan() {
        List<Integer> features = new ArrayList<>();
        features.add(0); // Personal Trainer Sessions
        assertFalse(manager.isValidSelection(5, features)); // Invalid Membership Index
    }

    @Test
    public void testIsValidSelectionInvalidFeature() {
        List<Integer> features = new ArrayList<>();
        features.add(5); // Invalid Feature Index
        assertFalse(manager.isValidSelection(0, features)); // Basic Membership
    }
    
}
