package sa.com.cloudsolutions.antikythera.testhelper.depsolver;

public class DepsolverBase {
    protected String baseField;
    protected String baseOther;
    protected DepsolverHelper baseHelper;

    public DepsolverBase() {
        this("base");
    }

    public DepsolverBase(String baseField) {
        this.baseField = baseField;
        this.baseOther = "other";
        this.baseHelper = new DepsolverHelper("baseHelper");
    }

    public String getBaseField() {
        return baseField;
    }
}
