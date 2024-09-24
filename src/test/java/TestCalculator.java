import com.tricon.poc.Main;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;

public class TestCalculator {

    @BeforeClass
    public static void setUp() {
        System.out.println("Starting tests...");
    }

    @Test
    public void testEmptyInput() {
        assertEquals(0, Main.add(""));
    }

    @Test
    public void testSingleNumber() {
        assertEquals(8, Main.add("9"));
    }

    @Test
    public void testTwoNumbers() {
        assertEquals(8, Main.add("5,3"));
    }

    @Test
    public void testNumbersInLines() {
        assertEquals(9, Main.add("3,3\n3"));
        assertEquals(10, Main.add("1\n2,3,4"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeNumbers() {
        Main.add("1,-2,3");
    }

    @Test
    public void testAddWithMultipleNumbersIncludingBiggerThan1000() {
        assertEquals(1006, Main.add("1000,2,3000,4"));
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("All tests completed.");
    }
}
