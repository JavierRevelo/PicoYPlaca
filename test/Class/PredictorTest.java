/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Class;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Zen
 */
public class PredictorTest {

     @Test
    public void testCanDriveAllowedCase() {
        Predictor predictor = new Predictor("ABC123", "01/01/2023", "08:30");
        assertTrue(predictor.canDrive());
    }

    @Test
    public void testCanDriveNotAllowedCase() {
        Predictor predictor = new Predictor("ABC123", "01/01/2023", "09:31");
        assertTrue(predictor.canDrive());
    }

    @Test
    public void testCanDriveWeekendCase() {
        Predictor predictor = new Predictor("ABC123", "01/01/2023", "10:00");
        assertTrue(predictor.canDrive());
    }

    @Test
    public void testIsWithinNotAllowedTimeAllowedCase() {
        Predictor predictor = new Predictor("ABC123", "01/01/2023", "08:30");
        assertTrue(predictor.isWithinNotAllowedTime());
    }

    @Test
    public void testIsWithinNotAllowedTimeNotAllowedCase() {
        Predictor predictor = new Predictor("ABC123", "01/01/2023", "09:31");
        assertFalse(predictor.isWithinNotAllowedTime());
    }

    @Test
    public void testIsPlateAllowedValidCase() {
        Predictor predictor = new Predictor("ABC123", "01/01/2023", "12:00");
        assertEquals(3, predictor.isPlateAllowed());
    }

    @Test
    public void testIsPlateAllowedInvalidCase() {
        Predictor predictor = new Predictor("ABC12X", "01/01/2023", "12:00");
        assertEquals(-1, predictor.isPlateAllowed());
    }

    @Test
    public void testIdentifyDayOfTheWeekValidCase() {
        Predictor predictor = new Predictor("ABC123", "01/01/2023", "12:00");
        assertNotNull(predictor.identifyDayOfTheWeek());
    }

    @Test
    public void testIdentifyDayOfTheWeekInvalidCase() {
        Predictor predictor = new Predictor("ABC123", "invalid_date", "12:00");
        assertNull(predictor.identifyDayOfTheWeek());
    }
    
    
        @Test
    public void testIsWithinAllowedTimeMorningBoundary() {
        Predictor predictor = new Predictor("ABC123", "01/01/2023", "07:00");
        assertTrue(predictor.isWithinNotAllowedTime());
    }

    @Test
    public void testIsWithinAllowedTimeMorning() {
        Predictor predictor = new Predictor("ABC123", "01/01/2023", "09:30");
        assertTrue(predictor.isWithinNotAllowedTime());
    }

    @Test
    public void testIsWithinAllowedTimeAfternoonBoundary() {
        Predictor predictor = new Predictor("ABC123", "01/01/2023", "16:00");
        assertTrue(predictor.isWithinNotAllowedTime());
    }

    @Test
    public void testIsWithinAllowedTimeAfternoon() {
        Predictor predictor = new Predictor("ABC123", "01/01/2023", "19:30");
        assertTrue(predictor.isWithinNotAllowedTime());
    }

    @Test
    public void testIsWithinAllowedTimeOutOfBoundaryMorning() {
        Predictor predictor = new Predictor("ABC123", "01/01/2023", "09:31");
        assertFalse(predictor.isWithinNotAllowedTime());
    }

    @Test
    public void testIsWithinAllowedTimeOutOfBoundaryAfternoon() {
        Predictor predictor = new Predictor("ABC123", "01/01/2023", "19:31");
        assertFalse(predictor.isWithinNotAllowedTime());
    }
    
}
