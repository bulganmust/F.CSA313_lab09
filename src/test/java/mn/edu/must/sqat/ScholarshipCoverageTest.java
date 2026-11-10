package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScholarshipCoverageTest {
    private final ScholarshipCalculator calculator = new ScholarshipCalculator();

    @Test
    void gradeNegative_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.letterGrade(-1));
    }

    @Test
    void gradeAbove100_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.letterGrade(101));
    }

    @Test
    void gradeC_returnsC() {
        assertEquals("C", calculator.letterGrade(75));
    }

    @Test
    void gradeD_returnsD() {
        assertEquals("D", calculator.letterGrade(65));
    }

    @Test
    void gradeF_returnsF() {
        assertEquals("F", calculator.letterGrade(50));
    }

    @Test
    void gpaNull_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(null));
    }

    @Test
    void gpaEmpty_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.gpa(new double[]{}));
    }

    @Test
    void gpaAllGrades_returnsAverage() {
        assertEquals(2.0,
                calculator.gpa(new double[]{95, 85, 75, 65, 50}),
                0.000001);
    }

    @Test
    void scholarshipNegativeGpa_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(-0.1, 15, false));
    }

    @Test
    void scholarshipAboveFour_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(4.1, 15, false));
    }

    @Test
    void scholarshipNegativeCredits_throws() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.scholarship(3.9, -1, false));
    }

    @Test
    void scholarshipViolation_returnsZero() {
        assertEquals(0, calculator.scholarship(3.9, 16, true));
    }

    @Test
    void scholarshipHighGpaLowCredits_returns70() {
        assertEquals(70, calculator.scholarship(3.9, 14, false));
    }

    @Test
    void scholarshipMiddleGpaLowCredits_returns50() {
        assertEquals(50, calculator.scholarship(3.5, 11, false));
    }

    @Test
    void scholarshipLowGpa_returnsZero() {
        assertEquals(0, calculator.scholarship(2.5, 15, false));
    }
}
