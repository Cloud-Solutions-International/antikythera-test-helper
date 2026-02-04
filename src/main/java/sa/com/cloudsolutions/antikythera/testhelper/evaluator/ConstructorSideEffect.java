package sa.com.cloudsolutions.antikythera.testhelper.evaluator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConstructorSideEffect {
    private static final Logger logger = LoggerFactory.getLogger(ConstructorSideEffect.class);

    public ConstructorSideEffect() {
        System.out.println("Constructor side effect!");
        logger.info("Constructor log effect!");
    }
}
