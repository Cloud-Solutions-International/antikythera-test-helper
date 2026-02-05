package sa.com.cloudsolutions.antikythera.testhelper.depsolver;

public class DepsolverOverload implements OverloadIfc {
    @Override
    public String doIt(String value) {
        return value;
    }

    @Override
    public String doIt(int value) {
        return String.valueOf(value);
    }
}
