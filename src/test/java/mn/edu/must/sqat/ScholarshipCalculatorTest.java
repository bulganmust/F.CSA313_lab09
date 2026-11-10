package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScholarshipCalculatorTest {

    private final ScholarshipCalculator calculator =
            new ScholarshipCalculator();

    @Test
    void letterGrade_highScore_returnsA() {
        assertEquals("A", calculator.letterGrade(95));
    }

    @Test
    void gpa_twoScores_returnsAverage() {
        assertEquals(3.5,
                calculator.gpa(new double[]{95, 85}), 0.000001);
    }

    @Test
    void scholarship_highGpaAndCredits_returns100() {
        assertEquals(100, calculator.scholarship(3.9, 16, false));
    }

    @Test
    void scholarship_middleGpaAndCredits_returns70() {
        assertEquals(70, calculator.scholarship(3.5, 13, false));
    }

    @Test
    void scholarship_basicGpa_returns50() {
        assertEquals(50, calculator.scholarship(3.1, 10, false));
    }
}
