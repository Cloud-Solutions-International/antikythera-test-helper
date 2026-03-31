package sa.com.cloudsolutions.antikythera.testhelper.typewrapper;

/**
 * Test fixture for complex inheritance hierarchy testing (isAssignableFrom).
 * Used by TypeWrapper migration Phase 0 tests.
 *
 * Key test scenarios:
 * - Multi-level class inheritance
 * - Multi-level interface inheritance
 * - Diamond inheritance pattern
 * - Interface default methods
 * - Abstract class in hierarchy
 */
public class InheritanceHierarchy {

    // ========== Interface Hierarchy ==========

    /**
     * Base interface A
     */
    public interface BaseInterfaceA {
        void methodA();
    }

    /**
     * Base interface B
     */
    public interface BaseInterfaceB {
        void methodB();
    }

    /**
     * Interface extending single interface
     */
    public interface ExtendedInterfaceA extends BaseInterfaceA {
        void methodExtA();
    }

    /**
     * Interface extending multiple interfaces (diamond setup)
     */
    public interface CombinedInterface extends BaseInterfaceA, BaseInterfaceB {
        void methodCombined();
    }

    /**
     * Interface with default method
     */
    public interface InterfaceWithDefault extends BaseInterfaceA {
        default String getDefaultValue() {
            return "default";
        }
    }

    // ========== Class Hierarchy ==========

    /**
     * Abstract base class
     */
    public static abstract class AbstractBase {
        protected String baseName = "base";

        public abstract void doWork();

        public String getBaseName() {
            return baseName;
        }
    }

    /**
     * Concrete class extending abstract class
     */
    public static class ConcreteFromAbstract extends AbstractBase {
        @Override
        public void doWork() {
            System.out.println("Working in concrete");
        }
    }

    /**
     * Further extension
     */
    public static class ExtendedConcrete extends ConcreteFromAbstract {
        private String extendedName = "extended";

        public String getExtendedName() {
            return extendedName;
        }
    }

    // ========== Combined Class + Interface Hierarchy ==========

    /**
     * Class implementing single interface
     */
    public static class SingleInterfaceImpl implements BaseInterfaceA {
        @Override
        public void methodA() {
            System.out.println("methodA");
        }
    }

    /**
     * Class implementing multiple interfaces
     */
    public static class MultiInterfaceImpl implements BaseInterfaceA, BaseInterfaceB {
        @Override
        public void methodA() {
            System.out.println("methodA");
        }

        @Override
        public void methodB() {
            System.out.println("methodB");
        }
    }

    /**
     * Class extending and implementing
     */
    public static class ExtendAndImplement extends AbstractBase implements BaseInterfaceA, BaseInterfaceB {
        @Override
        public void doWork() {
            System.out.println("doWork");
        }

        @Override
        public void methodA() {
            System.out.println("methodA");
        }

        @Override
        public void methodB() {
            System.out.println("methodB");
        }
    }

    /**
     * Class implementing combined interface (diamond)
     */
    public static class DiamondImpl implements CombinedInterface {
        @Override
        public void methodA() {
            System.out.println("methodA from diamond");
        }

        @Override
        public void methodB() {
            System.out.println("methodB from diamond");
        }

        @Override
        public void methodCombined() {
            System.out.println("methodCombined");
        }
    }

    /**
     * Deep hierarchy: Class extends Class implements Interface extends Interface
     */
    public static class DeepHierarchy extends ExtendAndImplement implements ExtendedInterfaceA {
        @Override
        public void methodExtA() {
            System.out.println("methodExtA");
        }
    }

    // ========== Generic Inheritance ==========

    /**
     * Generic interface
     */
    public interface GenericInterface<T> {
        T getValue();
        void setValue(T value);
    }

    /**
     * Parameterized implementation
     */
    public static class StringGenericImpl implements GenericInterface<String> {
        private String value;

        @Override
        public String getValue() {
            return value;
        }

        @Override
        public void setValue(String value) {
            this.value = value;
        }
    }

    /**
     * Generic class with bounded type parameter
     */
    public static class BoundedGenericClass<T extends Number & Comparable<T>> implements GenericInterface<T> {
        private T value;

        @Override
        public T getValue() {
            return value;
        }

        @Override
        public void setValue(T value) {
            this.value = value;
        }
    }
}
