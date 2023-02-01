import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    Calculator calc;
    @BeforeEach
    void setUp() {
        calc = new Calculator();
    }

    @AfterEach
    void tearDown() {
    }
    @Test
    public void testAdd(){
        System.out.println("testAdd");
        int actual = calc.add(1,2);
        int expected = 3;
        assertEquals(expected,actual);
    }
}
