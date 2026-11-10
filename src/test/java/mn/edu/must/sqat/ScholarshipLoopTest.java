package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScholarshipLoopTest {
    private final ScholarshipCalculator calculator = new ScholarshipCalculator();

    @Test
    void gpa_zeroElements_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(new double[]{}));
    }

    @Test
    void gpa_oneElement_returnsItsPoints() {
        assertEquals(4.0,
                calculator.gpa(new double[]{95}),
                0.000001);
    }

    @Test
    void gpa_multipleElements_returnsAverage() {
        assertEquals(2.5,
                calculator.gpa(new double[]{95, 85, 75, 65}),
                0.000001);
    }
}
