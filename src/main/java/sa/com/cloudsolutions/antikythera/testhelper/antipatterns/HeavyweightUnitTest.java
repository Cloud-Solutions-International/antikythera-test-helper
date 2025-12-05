package sa.com.cloudsolutions.antikythera.testhelper.antipatterns;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

/**
 * Anti-pattern: Using @SpringBootTest for pure logic that doesn't need context.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HeavyweightUnitTest {

    @Autowired
    private SomeService someService;

    @Test
    public void testLogic() {
        // This should be a unit test but is loading the whole context
        assertEquals("result", someService.doSomething());
    }

    static class SomeService {
        public String doSomething() {
            return "result";
        }
    }
}
