package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

/**
 * Test fixture for enum parameter handling in ArgumentGenerator.
 * Tests that the ArgumentGenerator correctly generates arguments when methods take enum parameters.
 */
@SuppressWarnings("java:S106")
public class EnumProcessor {

    /**
     * Method that takes a simple enum parameter.
     * ArgumentGenerator should generate: Status status = Status.OPEN;
     */
    public String processStatus(Status status) {
        return status.toString();
    }

    /**
     * Method that takes a multi-field enum parameter.
     * ArgumentGenerator should generate: MultiFieldEnum field = MultiFieldEnum.SMILEY;
     */
    public int processMultiField(MultiFieldEnum field) {
        return field.getId();
    }

    /**
     * Method that takes multiple enum parameters.
     */
    public String processMultiple(Status status, MultiFieldEnum field) {
        return status.toString() + field.getName();
    }

    /**
     * Method with mixed parameters (enum and primitives).
     */
    public String mixedParameters(String name, Status status, int count) {
        return name + "-" + status + "-" + count;
    }
}
