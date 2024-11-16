package Skills.JunitWitMockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Skills.JunitWitMockito.calculator.calculator;

/**
 * Unit test for simple App.
 */
public class CalculatorTest {

    static calculator c = null;  // Use static for class-level management

    // This method should be static when using @BeforeAll
    @BeforeAll
    public static void setup() {
        c = new calculator();
    }

    @Test    
    public void testAdd() {
        int expected = 30;
        int actual = c.add(10, 20);
        assertEquals(expected, actual);  // Verify that 10 + 20 = 30
    }

    @Test
    public void isEven() {
        boolean actual = c.isEven(3);  // Check if 3 is even
        assertTrue(!actual);  // Expect false, since 3 is odd
    }
    
    @Test
    public void percentTest() {
    	int num = c.percent(13);
    	int actual = 13;
    	assertEquals(num, actual);
    }

    // This method should be static when using @AfterAll
    @AfterAll
    public static void cleanUp() {
        c = null;
    }
}
