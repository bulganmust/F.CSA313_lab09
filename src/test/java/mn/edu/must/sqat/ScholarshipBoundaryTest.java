package mn.edu.must.sqat;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ScholarshipBoundaryTest {
    private final ScholarshipCalculator calculator = new ScholarshipCalculator();

    @Test
    void grade60_returnsD() {
        assertEquals("D", calculator.letterGrade(60));
    }

    @Test
    void grade59Point99_returnsF() {
        assertEquals("F", calculator.letterGrade(59.99));
    }

    @Test
    void grade69Point99_returnsD() {
        assertEquals("D", calculator.letterGrade(69.99));
    }

    @Test
    void grade0_returnsF() {
        assertEquals("F", calculator.letterGrade(0));
    }

    @Test
    void grade100_returnsA() {
        assertEquals("A", calculator.letterGrade(100));
    }

    @Test
    void grade89Point99_returnsB() {
        assertEquals("B", calculator.letterGrade(89.99));
    }

    @Test
    void grade90_returnsA() {
        assertEquals("A", calculator.letterGrade(90));
    }
}
