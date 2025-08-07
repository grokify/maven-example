package com.example.app;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for MathUtils class.
 */
public class MathUtilsTest {
    
    private MathUtils mathUtils;
    
    @BeforeEach
    void setUp() {
        mathUtils = new MathUtils();
    }
    
    @Test
    void testAdd() {
        assertEquals(8, mathUtils.add(5, 3));
        assertEquals(0, mathUtils.add(-1, 1));
        assertEquals(-5, mathUtils.add(-2, -3));
    }
    
    @Test
    void testMultiply() {
        assertEquals(15, mathUtils.multiply(5, 3));
        assertEquals(0, mathUtils.multiply(0, 5));
        assertEquals(-10, mathUtils.multiply(-2, 5));
    }
}
