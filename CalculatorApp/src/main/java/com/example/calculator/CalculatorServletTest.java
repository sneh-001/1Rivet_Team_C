package com.example.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServletTest {

    @Test
    public void testAddition() {
        double num1 = 5;
        double num2 = 3;
        double expected = 8;
        double result = Calculator.add(num1, num2); // Assuming you have an add method
        assertEquals(expected, result);
    }

    @Test
    public void testSubtraction() {
        double num1 = 5;
        double num2 = 3;
        double expected = 2;
        double result = Calculator.subtract(num1, num2); // Assuming you have a subtract method
        assertEquals(expected, result);
    }

    @Test
    public void testMultiplication() {
        double num1 = 5;
        double num2 = 3;
        double expected = 15;
        double result = Calculator.multiply(num1, num2); // Assuming you have a multiply method
        assertEquals(expected, result);
    }

    @Test
    public void testDivision() {
        double num1 = 6;
        double num2 = 3;
        double expected = 2;
        double result = Calculator.divide(num1, num2); // Assuming you have a divide method
        assertEquals(expected, result);
    }

    @Test
    public void testDivisionByZero() {
        double num1 = 5;
        double num2 = 0;
        
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            Calculator.divide(num1, num2); // Assuming your divide method throws an exception for division by zero
        });
        
        String expectedMessage = "Cannot divide by zero";
        String actualMessage = exception.getMessage();
        
        assertTrue(actualMessage.contains(expectedMessage));
    }
}
