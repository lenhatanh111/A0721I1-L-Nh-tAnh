package ss8_clean_code_and_refactoring.thuc_hanh.bai_1_refactoring_doi_ten_bien_va_tach_hang;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class TestCalculate {
    public static final char ADDITION = '+';
    public static final char SUBTRACTION = '-';
    public static final char MULTIPLICATION = '*';
    public static final char DIVISION = '/';
    public static final char EQUAL = '=';
    private calculate Calculator;

    @Test
    @DisplayName("Testing addition")
    void testCalculateAdd() {
        int firstOperator = 1;
        int secondOperator = 1;
        int expected = 2;

        int result = Calculator.calculate(firstOperator, secondOperator, ADDITION);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing subtraction")
    void testCalculateSub() {
        int firstOperator = 2;
        int secondOperator = 1;
        int expected = 1;

        int result = Calculator.calculate(firstOperator, secondOperator, SUBTRACTION);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing multiplication")
    void testCalculateMul() {
        int firstOperator = 2;
        int secondOperator = 2;
        int expected = 4;

        int result = Calculator.calculate(firstOperator, secondOperator, MULTIPLICATION);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing division")
    void testCalculateDiv() {
        int firstOperator = 6;
        int secondOperator = 3;
        int expected = 2;

        int result = Calculator.calculate(firstOperator, secondOperator, DIVISION);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Testing division by zero")
    void testCalculateDivByZero() {
        int firstOperator = 2;
        int secondOperator = 0;

        assertThrows(RuntimeException.class,
                ()-> {Calculator.calculate(firstOperator, secondOperator, DIVISION);});
    }

    @Test
    @DisplayName("Testing wrong operator")
    void testCalculateWrongOperator() {
        int firstOperator = 2;
        int secondOperator = 0;
        assertThrows(RuntimeException.class,
                ()-> {Calculator.calculate(firstOperator, secondOperator, EQUAL);});
    }
}
