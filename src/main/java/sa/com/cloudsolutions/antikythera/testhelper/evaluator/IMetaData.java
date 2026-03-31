package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

/**
 * Minimal interface to simulate a MetaData-like type returned from IContext.getMetaData().
 */
public class IMetaData {
    private String userId;

    public IMetaData() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
