package sa.com.cloudsolutions.antikythera.testhelper.typewrapper;

import java.util.function.Function;

/**
 * Test fixture for complex enum constant resolution testing.
 * Used by TypeWrapper migration Phase 0 tests.
 *
 * Key test scenarios:
 * - Enum constants with constructor parameters
 * - Enum constants with multiple fields
 * - Enum with methods (abstract and concrete)
 * - Enum implementing interfaces
 * - Enum constant bodies (anonymous class-like)
 */
public enum ComplexEnum implements Comparable<ComplexEnum> {

    // Constants with constructor parameters
    VALUE_A("A", 1, true) {
        @Override
        public String describe() {
            return "Value A: " + getCode();
        }
    },
    VALUE_B("B", 2, false) {
        @Override
        public String describe() {
            return "Value B: " + getCode();
        }
    },
    VALUE_C("C", 3, true) {
        @Override
        public String describe() {
            return "Value C: " + getCode();
        }
    };

    private final String code;
    private final int ordinalValue;
    private final boolean active;

    // Constructor with multiple parameters
    ComplexEnum(String code, int ordinalValue, boolean active) {
        this.code = code;
        this.ordinalValue = ordinalValue;
        this.active = active;
    }

    // Abstract method - each constant must implement
    public abstract String describe();

    // Concrete method
    public String getCode() {
        return code;
    }

    public int getOrdinalValue() {
        return ordinalValue;
    }

    public boolean isActive() {
        return active;
    }

    // Static method to find by code
    public static ComplexEnum fromCode(String code) {
        for (ComplexEnum value : values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unknown code: " + code);
    }

    // Static method with enum parameter
    public static boolean isActiveStatus(ComplexEnum status) {
        return status != null && status.active;
    }

    /**
     * Nested enum for additional testing
     */
    public enum NestedStatus {
        PENDING, PROCESSING, COMPLETED, FAILED
    }

    /**
     * Simple enum (no constructor parameters) for comparison
     */
    public enum SimpleEnum {
        ONE, TWO, THREE
    }

    /**
     * Enum with functional interface field
     */
    public enum FunctionalEnum {
        UPPERCASE(String::toUpperCase),
        LOWERCASE(String::toLowerCase),
        TRIM(String::trim);

        private final Function<String, String> transformer;

        FunctionalEnum(Function<String, String> transformer) {
            this.transformer = transformer;
        }

        public String apply(String input) {
            return transformer.apply(input);
        }
    }
}
