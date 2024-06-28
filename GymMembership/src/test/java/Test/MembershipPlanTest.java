/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Test;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.mycompany.gymmembership.MembershipPlan;

/**
 *
 * @author sisua
 */
public class MembershipPlanTest {
    
    @Test
    public void testGetName() {
        MembershipPlan plan = new MembershipPlan("Basic Membership", "Access during standard hours", 50.0);
        assertEquals("Basic Membership", plan.getName());
    }

    @Test
    public void testGetBenefits() {
        MembershipPlan plan = new MembershipPlan("Basic Membership", "Access during standard hours", 50.0);
        assertEquals("Access during standard hours", plan.getBenefits());
    }

    @Test
    public void testGetBaseCost() {
        MembershipPlan plan = new MembershipPlan("Basic Membership", "Access during standard hours", 50.0);
        assertEquals(50.0, plan.getBaseCost());
    }

    @Test
    public void testIsAvailable() {
        MembershipPlan plan = new MembershipPlan("Basic Membership", "Access during standard hours", 50.0);
        assertTrue(plan.isAvailable());
    }

    @Test
    public void testSetAvailable() {
        MembershipPlan plan = new MembershipPlan("Basic Membership", "Access during standard hours", 50.0);
        plan.setAvailable(false);
        assertFalse(plan.isAvailable());
    }

    @Test
    public void testToString() {
        MembershipPlan plan = new MembershipPlan("Basic Membership", "Access during standard hours", 50.0);
        assertEquals("Basic Membership - Access during standard hours: $50.0", plan.toString());
    }
}
