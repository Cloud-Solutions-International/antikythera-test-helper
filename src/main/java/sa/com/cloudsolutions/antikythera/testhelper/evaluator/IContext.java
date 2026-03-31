package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

/**
 * Minimal interface to simulate an autowired context interface like
 * com.csi.microservices.base.context.Context. Used by ContextAwareService.
 */
public interface IContext {
    IMetaData getMetaData();
}
