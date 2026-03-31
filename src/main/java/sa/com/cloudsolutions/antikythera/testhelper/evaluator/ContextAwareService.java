package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Test helper service that mimics the WorkListServiceImpl pattern:
 * - has an @Autowired interface field (IContext)
 * - uses a chained method call context.getMetaData().getUserId()
 * - has a null-check on the parameter before using the context
 */
@Service
public class ContextAwareService {

    @Autowired
    private IContext context;

    public void processRequest(String payload) {
        if (payload != null) {
            String userId = context.getMetaData().getUserId();
            System.out.println("Processing for user: " + userId + ", payload: " + payload);
        }
    }
}
