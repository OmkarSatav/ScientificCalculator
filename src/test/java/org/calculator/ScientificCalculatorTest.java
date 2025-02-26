package org.calculator;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class ScientificCalculatorTest {

    @Test
    public void testSquareRoot() {

        assertEquals(3.0, ScientificCalculator.squareRoot(9.0), 0.001);
        assertThrows(IllegalArgumentException.class, () -> ScientificCalculator.squareRoot(-4.0));
    }

    @Test
    public void testFactorial() {

        assertEquals(1, ScientificCalculator.factorial(0));


        assertEquals(120, ScientificCalculator.factorial(5));


        assertThrows(IllegalArgumentException.class, () -> ScientificCalculator.factorial(-1));
    }

    @Test
    public void testNaturalLog() {

        assertEquals(Math.log(10), ScientificCalculator.naturalLog(10), 0.001);
        assertThrows(IllegalArgumentException.class, () -> ScientificCalculator.naturalLog(0));
        assertThrows(IllegalArgumentException.class, () -> ScientificCalculator.naturalLog(-5));
    }

    @Test
    public void testPower() {
        assertEquals(8.0, ScientificCalculator.power(2.0, 3.0), 0.001);

        assertEquals(1.0, ScientificCalculator.power(2.0, 0.0), 0.001);
    }
}