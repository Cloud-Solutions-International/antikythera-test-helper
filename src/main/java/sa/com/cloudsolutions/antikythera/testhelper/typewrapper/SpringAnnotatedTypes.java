package sa.com.cloudsolutions.antikythera.testhelper.typewrapper;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;

/**
 * Test fixture for Spring annotation detection testing.
 * Used by TypeWrapper migration Phase 0 tests.
 *
 * Key test scenarios:
 * - @Service annotation detection
 * - @Controller annotation detection
 * - @Repository annotation detection
 * - @Component annotation detection
 * - Annotation detection on both AST and reflection-loaded types
 */
public class SpringAnnotatedTypes {

    /**
     * Class annotated with @Service
     */
    @Service
    public static class TestService {
        public String doServiceWork() {
            return "service work";
        }
    }

    /**
     * Class annotated with @Controller
     */
    @Controller
    public static class TestController {
        public String handleRequest() {
            return "handled";
        }
    }

    /**
     * Class annotated with @Repository
     */
    @Repository
    public static class TestRepository {
        public String getResource() {
            return "resource";
        }
    }

    /**
     * Class annotated with @Component
     */
    @Component
    public static class TestComponent {
        public void componentWork() {
            System.out.println("component work");
        }
    }

    /**
     * Class with no Spring annotation (negative test case)
     */
    public static class PlainClass {
        public void plainMethod() {
            System.out.println("plain method");
        }
    }

    /**
     * Service extending abstract base
     */
    @Service
    public static class ExtendedService extends AbstractBaseService {
        @Override
        public String process() {
            return "extended processing";
        }
    }

    /**
     * Abstract base class (not annotated)
     */
    public static abstract class AbstractBaseService {
        public abstract String process();

        public String commonMethod() {
            return "common";
        }
    }

    /**
     * Named service with custom bean name
     */
    @Service("customServiceName")
    public static class NamedService {
        public String namedWork() {
            return "named work";
        }
    }

    /**
     * Component implementing interface
     */
    @Component
    public static class ComponentWithInterface implements ServiceInterface {
        @Override
        public void serve() {
            System.out.println("serving");
        }
    }

    /**
     * Interface for service (not annotated)
     */
    public interface ServiceInterface {
        void serve();
    }
}
