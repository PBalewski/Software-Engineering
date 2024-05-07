package put.io.testing.audiobooks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import put.io.testing.junit.Calculator;

import static org.junit.jupiter.api.Assertions.*;

class AudiobookPriceCalculatorTest {
    private AudiobookPriceCalculator audiobookPriceCalculator;
    private Audiobook audiobook = new Audiobook("Audiobook", 100);

    @BeforeEach
    public void setUp() {
        audiobookPriceCalculator = new AudiobookPriceCalculator();
    }

    @Test
    public void testSubsriberPath() {
        Customer customer = new Customer("Customer1", Customer.LoyaltyLevel.STANDARD, true);
        assertEquals(0, audiobookPriceCalculator.calculate(customer, audiobook));
    }

    @Test
    public void testSILVERPath() {
        Customer customer = new Customer("Customer1", Customer.LoyaltyLevel.SILVER, false);
        assertEquals(90, audiobookPriceCalculator.calculate(customer, audiobook));
    }

    @Test
    public void testGOLDPath() {
        Customer customer = new Customer("Customer1", Customer.LoyaltyLevel.GOLD, false);
        assertEquals(80, audiobookPriceCalculator.calculate(customer, audiobook));
    }

    @Test
    public void testSTANDARDPath() {
        Customer customer = new Customer("Customer1", Customer.LoyaltyLevel.STANDARD, false);
        assertEquals(100, audiobookPriceCalculator.calculate(customer, audiobook));
    }
}