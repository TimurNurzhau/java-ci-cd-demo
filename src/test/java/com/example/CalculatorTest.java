package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(0, calculator.add(-2, 2));
        assertEquals(-5, calculator.add(-2, -3));
    }

    @Test
    public void testSubtract() {
        assertEquals(1, calculator.subtract(3, 2));
        assertEquals(-5, calculator.subtract(2, 7));
        assertEquals(0, calculator.subtract(5, 5));
    }

    @Test
    public void testMultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(-6, calculator.multiply(2, -3));
        assertEquals(0, calculator.multiply(5, 0));
    }

    @Test
    public void testDivide() {
        assertEquals(2.0, calculator.divide(6, 3));
        assertEquals(2.5, calculator.divide(5, 2));
        assertEquals(-2.0, calculator.divide(-6, 3));
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
        assertThrows(ArithmeticException.class, () -> calculator.divide(-10, 0));
    }

    @Test
    public void testCalculatorIntegration() {
        // Интеграционный тест: последовательность операций
        double result = calculator.divide(
                calculator.multiply(
                        calculator.add(2, 3),
                        calculator.subtract(7, 2)
                ),
                5
        );
        assertEquals(5.0, result);
    }
}