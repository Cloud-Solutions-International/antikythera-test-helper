package sa.com.cloudsolutions.antikythera.testhelper.antipatterns;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Anti-pattern: Using @ContextConfiguration which should be modernized.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { LegacyContextTest.Config.class })
public class LegacyContextTest {

    @Test
    public void testContext() {
        // test
    }

    static class Config {
    }
}
