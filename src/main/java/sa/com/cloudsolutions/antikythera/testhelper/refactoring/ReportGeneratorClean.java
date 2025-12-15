package sa.com.cloudsolutions.antikythera.testhelper.refactoring;

import java.util.Map;

/**
 * Clean version of ReportGenerator with extracted table formatting helper.
 * This is the expected result after refactoring ReportGeneratorDup.
 */
public class ReportGeneratorClean {

    private String generateTableReport(String title, Map<String, Integer> data) {
        StringBuilder report = new StringBuilder();
        report.append("╔══════════════════════════════╗\n");
        report.append(String.format("║   %-26s║\n", title));
        report.append("╚══════════════════════════════╝\n\n");

        int total = 0;
        for (Map.Entry<String, Integer> entry : data.entrySet()) {
            report.append(String.format("%-20s: $%,6d\n", entry.getKey(), entry.getValue()));
            total += entry.getValue();
        }

        report.append("\n" + "─".repeat(30) + "\n");
        report.append(String.format("%-20s: $%,6d\n", "TOTAL", total));
        return report.toString();
    }

    public String generateSalesReport(Map<String, Integer> salesData) {
        return generateTableReport("SALES REPORT", salesData);
    }

    public String generateInventoryReport(Map<String, Integer> inventoryData) {
        return generateTableReport("INVENTORY REPORT", inventoryData);
    }

    public String generateExpenseReport(Map<String, Integer> expenseData) {
        return generateTableReport("EXPENSE REPORT", expenseData);
    }
}
