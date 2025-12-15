package sa.com.cloudsolutions.antikythera.testhelper.refactoring;

/**
 * Clean version of SimpleCalculator with refactored helper method.
 * This is the expected result after refactoring SimpleCalculatorDup.
 */
public class SimpleCalculatorClean {

    private int calculateWithTax(int a, int b) {
        int sum = a + b;
        int tax = sum * 10 / 100;
        return sum + tax;
    }

    public int calculateTotal(int a, int b) {
        return calculateWithTax(a, b);
    }

    public int calculateGrandTotal(int x, int y) {
        return calculateWithTax(x, y);
    }

    public int calculateFinalAmount(int first, int second) {
        return calculateWithTax(first, second);
    }
}
