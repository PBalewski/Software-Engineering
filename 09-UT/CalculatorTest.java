package put.io.testing.junit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void testadd() {
        assertEquals(5, calculator.add(2, 3));
        assertEquals(-2, calculator.add(-5, 3));
    }


    @Test
    public void testmultiply() {
        assertEquals(6, calculator.multiply(2, 3));
        assertEquals(15, calculator.multiply(-5, -3));
    }

    @Test
    public void testaddPositiveNumbers() {
        assertThrows(IllegalArgumentException.class, () -> calculator.addPositiveNumbers(-2, 3));
        assertEquals(5, calculator.addPositiveNumbers(2, 3));;
    }
}