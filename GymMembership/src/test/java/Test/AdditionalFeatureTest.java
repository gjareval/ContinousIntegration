/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.mycompany.gymmembership.AdditionalFeature;

/**
 *
 * @author sisua
 */
public class AdditionalFeatureTest {
    
@Test
    public void testGetName() {
        AdditionalFeature feature = new AdditionalFeature("Personal Trainer Sessions", 30.0);
        assertEquals("Personal Trainer Sessions", feature.getName());
    }

    @Test
    public void testGetCost() {
        AdditionalFeature feature = new AdditionalFeature("Personal Trainer Sessions", 30.0);
        assertEquals(30.0, feature.getCost());
    }

    @Test
    public void testToString() {
        AdditionalFeature feature = new AdditionalFeature("Personal Trainer Sessions", 30.0);
        assertEquals("Personal Trainer Sessions: $30.0", feature.toString());
    }
}
