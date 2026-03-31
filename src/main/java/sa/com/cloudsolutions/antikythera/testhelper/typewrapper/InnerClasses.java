package sa.com.cloudsolutions.antikythera.testhelper.typewrapper;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Test fixture for inner class and nested type resolution testing.
 * Used by TypeWrapper migration Phase 0 tests.
 *
 * Key test scenarios:
 * - Static nested classes
 * - Non-static inner classes
 * - Local classes (defined in method)
 * - Anonymous classes
 * - Multiple nesting levels
 */
public class InnerClasses {

    private String outerField = "outer";

    /**
     * Static nested class - can be accessed without outer instance.
     * FQN: sa.com.cloudsolutions.antikythera.testhelper.typewrapper.InnerClasses.StaticNested
     */
    public static class StaticNested {
        private String nestedField = "static nested";

        public String getNestedField() {
            return nestedField;
        }

        public void setNestedField(String nestedField) {
            this.nestedField = nestedField;
        }

        // Static nested can have its own static nested
        public static class DeeplyNested {
            private int depth = 2;

            public int getDepth() {
                return depth;
            }
        }
    }

    /**
     * Non-static inner class - requires outer instance.
     * FQN: sa.com.cloudsolutions.antikythera.testhelper.typewrapper.InnerClasses.Inner
     */
    public class Inner {
        private String innerField = "inner";

        public String getInnerField() {
            return innerField;
        }

        public String accessOuter() {
            // Can access outer class fields
            return outerField + " " + innerField;
        }

        // Inner class can have its own inner class
        public class DeeplyInner {
            public String accessAll() {
                return outerField + " " + innerField + " deeply inner";
            }
        }
    }

    /**
     * Private static nested class
     */
    private static class PrivateStaticNested {
        private String value = "private static";

        public String getValue() {
            return value;
        }
    }

    /**
     * Interface as nested type
     */
    public interface NestedInterface {
        void doSomething();
    }

    /**
     * Enum as nested type
     */
    public enum NestedEnum {
        VALUE_A, VALUE_B, VALUE_C
    }

    /**
     * Method demonstrating local class (class defined inside method)
     */
    public String useLocalClass() {
        class LocalClass {
            private final String localField = "local";

            public String getValue() {
                return localField + " in " + outerField;
            }
        }

        LocalClass local = new LocalClass();
        return local.getValue();
    }

    /**
     * Method returning anonymous class implementing an interface
     */
    public Runnable createAnonymousRunnable() {
        return new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous runnable: " + outerField);
            }
        };
    }

    /**
     * Method returning anonymous class extending a class
     */
    public Comparator<String> createAnonymousComparator() {
        return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        };
    }

    /**
     * Lambda expression (not anonymous class, but related)
     */
    public Consumer<String> createLambda() {
        return s -> System.out.println(outerField + ": " + s);
    }

    /**
     * Method reference (not anonymous class, but related)
     */
    public Consumer<String> createMethodReference() {
        return System.out::println;
    }

    // Factory methods for nested types
    public static StaticNested createStaticNested() {
        return new StaticNested();
    }

    public Inner createInner() {
        return new Inner();
    }

    public NestedInterface createNestedInterfaceImpl() {
        return new NestedInterface() {
            @Override
            public void doSomething() {
                System.out.println("Doing something");
            }
        };
    }

    // Getters/setters
    public String getOuterField() {
        return outerField;
    }

    public void setOuterField(String outerField) {
        this.outerField = outerField;
    }
}
