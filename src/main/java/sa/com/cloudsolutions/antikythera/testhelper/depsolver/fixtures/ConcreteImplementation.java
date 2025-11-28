package sa.com.cloudsolutions.antikythera.testhelper.depsolver.fixtures;

/**
 * Test fixture: Concrete class implementing InterfaceC (which extends B which extends A)
 */
public class ConcreteImplementation implements InterfaceC {

    @Override
    public void methodA() {
        System.out.println("Method A");
    }

    @Override
    public void methodB() {
        System.out.println("Method B");
    }

    @Override
    public void methodC() {
        System.out.println("Method C");
    }
}

