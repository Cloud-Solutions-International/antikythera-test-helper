package sa.com.cloudsolutions.antikythera.testhelper.depsolver;

public class DepsolverSample extends DepsolverBase {
    private String localField = "local";
    private DepsolverHelper helper = new DepsolverHelper("init");
    private String combined = build(localField);

    private static DepsolverHelper staticHelper;

    static {
        staticHelper = new DepsolverHelper("static");
    }

    {
        localField = compute();
    }

    public DepsolverSample() {
        this("ctor");
    }

    public DepsolverSample(String value) {
        super(value);
        this.localField = value;
    }

    private String compute() {
        return "computed";
    }

    private String build(String input) {
        return input + helper.getValue();
    }

    public void useFields() {
        localField = "assigned";
        DepsolverHelper a = this.helper;
        DepsolverHelper b = super.baseHelper;
        DepsolverHelper h = new DepsolverHelper("new");
        String v = h.getValue();
        String c = combined;
    }
}
