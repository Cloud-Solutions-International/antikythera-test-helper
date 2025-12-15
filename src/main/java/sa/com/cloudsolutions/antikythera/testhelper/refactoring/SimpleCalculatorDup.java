package sa.com.cloudsolutions.antikythera.testhelper.refactoring;

/**
 * Test class with exact duplicate code blocks in instance methods.
 * This class intentionally contains duplicates to test refactoring
 * capabilities.
 */
public class SimpleCalculatorDup {

    public int calculateTotal(int a, int b) {
        int sum = a + b;
        int tax = sum * 10 / 100;
        return sum + tax;
    }

    public int calculateGrandTotal(int x, int y) {
        int sum = x + y;
        int tax = sum * 10 / 100;
        return sum + tax;
    }

    public int calculateFinalAmount(int first, int second) {
        int sum = first + second;
        int tax = sum * 10 / 100;
        return sum + tax;
    }
}
