package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

import java.util.ArrayList;
import java.util.List;

/**
 * Test fixture for ControlFlowEvaluator's setter argument resolution and output parameter detection.
 * Covers resolveSetterArgument, domainValueToExpression, and isPassedToMethodBeforeCondition.
 */
@SuppressWarnings("java:S106")
public class SetterTester {

    private String name;
    private boolean active;
    private int count;
    private long timestamp;
    private double score;
    private float rating;
    private List<String> errors;
    private List<String> warnings;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    /**
     * Test method with conditional checks on getters.
     * Tests that ControlFlowEvaluator.resolveSetterArgument creates valid setter calls
     * with proper type adaptation (e.g., Integer -> Long, String -> boolean).
     */
    public String processIfNameIsEmpty() {
        if (getName().isEmpty()) {
            return "empty";
        }
        return "not empty";
    }

    /**
     * Test boolean getter in condition.
     */
    public String processIfActive() {
        if (isActive()) {
            return "active";
        }
        return "inactive";
    }

    /**
     * Test numeric comparison.
     */
    public String processIfCountGreaterThanZero() {
        if (getCount() > 0) {
            return "positive";
        }
        return "zero or negative";
    }

    /**
     * Test long setter argument generation from truth table domain value.
     */
    public String processIfTimestampSet() {
        if (getTimestamp() > 0) {
            return "timestamp set";
        }
        return "no timestamp";
    }

    /**
     * Test output parameter pattern: errors list is passed to a helper method before checking.
     * This tests isPassedToMethodBeforeCondition logic - the condition check should NOT
     * force the list to empty because it's an output parameter that gets populated by validateAndAddError.
     */
    public String validateWithOutputParameter(String input) {
        List<String> errorList = new ArrayList<>();
        validateAndAddError(input, errorList);
        if (errorList.isEmpty()) {
            return "valid";
        }
        return "invalid: " + errorList.get(0);
    }

    private void validateAndAddError(String input, List<String> errors) {
        if (input == null || input.isEmpty()) {
            errors.add("Input cannot be empty");
        }
    }

    /**
     * Similar pattern but for warnings - tests the output parameter detection with a different variable name.
     */
    public String checkWarnings(String data) {
        List<String> warningList = new ArrayList<>();
        addWarningIfNeeded(data, warningList);
        if (warningList.isEmpty()) {
            return "no warnings";
        }
        return "has warnings";
    }

    private void addWarningIfNeeded(String data, List<String> warnings) {
        if (data.length() > 100) {
            warnings.add("Data too long");
        }
    }

    /**
     * Non-output parameter pattern: local list NOT passed to method before condition.
     * This should allow the truth table to force it to empty.
     */
    public String checkLocalList(List<String> items) {
        if (items.isEmpty()) {
            return "empty";
        }
        return "not empty";
    }
}
