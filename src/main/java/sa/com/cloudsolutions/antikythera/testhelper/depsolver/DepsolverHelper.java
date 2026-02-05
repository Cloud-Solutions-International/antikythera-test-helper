package sa.com.cloudsolutions.antikythera.testhelper.depsolver;

public class DepsolverHelper {
    private final String value;

    public DepsolverHelper() {
        this("default");
    }

    public DepsolverHelper(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
