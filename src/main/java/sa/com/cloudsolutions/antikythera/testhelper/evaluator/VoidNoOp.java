package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

public class VoidNoOp {
    public void noSideEffect() {
        int a = 1 + 1;
    }

    public void hasSideEffect() {
        System.out.println("Side effect!");
    }

    public int returnsValue() {
        return 42;
    }
}
