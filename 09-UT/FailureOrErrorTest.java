package put.io.testing.junit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FailureOrErrorTest {

    @Test
    public void test1() {
        assertEquals(0, 1);
    }

    @Test
    public void test2() {
        throw new RuntimeException("This is an arbitrary exception thrown in test2 method.");
    }

    @Test
    public void test3() {
        try {
            assertEquals(0, 1);
        } catch (AssertionError e) {
            e.printStackTrace();
        }
    }

}