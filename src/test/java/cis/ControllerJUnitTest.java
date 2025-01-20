/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package cis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author bjmaclean
 */
public class ControllerJUnitTest {

    public ControllerJUnitTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testLookupAStudent_JoelNO_average_INVALID() {

        double averageActual = Controller.lookupAStudent("JoelNO");
        assertEquals(-1, averageActual);
    }

    @Test
    public void testLookupAStudent_Joel_average_73() {

        double averageActual = Controller.lookupAStudent("Joel");
        assertEquals(73.333, averageActual, 0.01, "");
    }


}
