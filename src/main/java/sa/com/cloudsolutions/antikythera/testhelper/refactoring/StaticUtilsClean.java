package sa.com.cloudsolutions.antikythera.testhelper.refactoring;

/**
 * Clean version of StaticUtils with extracted static helper method.
 * This is the expected result after refactoring StaticUtilsDup.
 * CRITICAL: The helper method MUST be static since it's called from static
 * methods.
 */
public class StaticUtilsClean {

    private static String formatCurrency(double amount) {
        String formatted = String.format("%.2f", amount);
        formatted = "$" + formatted;
        return formatted;
    }

    public static String formatPrice(double amount) {
        return formatCurrency(amount);
    }

    public static String formatCost(double value) {
        return formatCurrency(value);
    }

    public static String formatTotal(double sum) {
        return formatCurrency(sum);
    }
}
