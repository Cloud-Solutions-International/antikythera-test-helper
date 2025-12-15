package sa.com.cloudsolutions.antikythera.testhelper.refactoring;

/**
 * Test class with duplicates in static methods.
 * This tests whether Bertie correctly adds static modifier to extracted helper
 * methods.
 */
public class StaticUtilsDup {

    public static String formatPrice(double amount) {
        String formatted = String.format("%.2f", amount);
        formatted = "$" + formatted;
        return formatted;
    }

    public static String formatCost(double value) {
        String formatted = String.format("%.2f", value);
        formatted = "$" + formatted;
        return formatted;
    }

    public static String formatTotal(double sum) {
        String formatted = String.format("%.2f", sum);
        formatted = "$" + formatted;
        return formatted;
    }
}
