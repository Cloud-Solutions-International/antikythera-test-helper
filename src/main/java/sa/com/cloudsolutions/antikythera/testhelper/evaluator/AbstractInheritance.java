package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

public class AbstractInheritance {
    public abstract static class AbstractBase {
        public abstract void abstractMethod(String s, int i);

        public void concreteMethod() {
        }
    }

    public static class ConcreteImplementation extends AbstractBase {
        @Override
        public void abstractMethod(String s, int i) {
            System.out.println(s + i);
        }
    }
}
