package sa.com.cloudsolutions.antikythera.testhelper.refactoring;

import java.util.Map;

/**
 * Test class with complex duplicates involving report generation and
 * formatting.
 * This tests Bertie's ability to handle string building, loops, and formatting
 * logic.
 */
public class ReportGeneratorDup {

    public String generateSalesReport(Map<String, Integer> salesData) {
        StringBuilder report = new StringBuilder();
        report.append("╔══════════════════════════════╗\n");
        report.append("║     SALES REPORT             ║\n");
        report.append("╚══════════════════════════════╝\n\n");

        int total = 0;
        for (Map.Entry<String, Integer> entry : salesData.entrySet()) {
            report.append(String.format("%-20s: $%,6d\n", entry.getKey(), entry.getValue()));
            total += entry.getValue();
        }

        report.append("\n" + "─".repeat(30) + "\n");
        report.append(String.format("%-20s: $%,6d\n", "TOTAL", total));
        return report.toString();
    }

    public String generateInventoryReport(Map<String, Integer> inventoryData) {
        StringBuilder report = new StringBuilder();
        report.append("╔══════════════════════════════╗\n");
        report.append("║   INVENTORY REPORT           ║\n");
        report.append("╚══════════════════════════════╝\n\n");

        int total = 0;
        for (Map.Entry<String, Integer> entry : inventoryData.entrySet()) {
            report.append(String.format("%-20s: $%,6d\n", entry.getKey(), entry.getValue()));
            total += entry.getValue();
        }

        report.append("\n" + "─".repeat(30) + "\n");
        report.append(String.format("%-20s: $%,6d\n", "TOTAL", total));
        return report.toString();
    }

    public String generateExpenseReport(Map<String, Integer> expenseData) {
        StringBuilder report = new StringBuilder();
        report.append("╔══════════════════════════════╗\n");
        report.append("║    EXPENSE REPORT            ║\n");
        report.append("╚══════════════════════════════╝\n\n");

        int total = 0;
        for (Map.Entry<String, Integer> entry : expenseData.entrySet()) {
            report.append(String.format("%-20s: $%,6d\n", entry.getKey(), entry.getValue()));
            total += entry.getValue();
        }

        report.append("\n" + "─".repeat(30) + "\n");
        report.append(String.format("%-20s: $%,6d\n", "TOTAL", total));
        return report.toString();
    }
}
