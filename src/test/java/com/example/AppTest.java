package com.example;

// Imports for JUnit 5 testing
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private App app;

    @BeforeEach
    public void setUp() {
        // This runs before each test
        app = new App();
    }

    /**
     * Test 1: Simple addition
     */
    @Test
    public void testSimpleAdd() {
        assertEquals(5, app.add(2, 3), "2 + 3 should equal 5");
    }

    /**
     * Test 2: Adding with a negative number
     */
    @Test
    public void testNegativeAdd() {
        assertEquals(-1, app.add(2, -3), "2 + (-3) should equal -1");
    }
}
