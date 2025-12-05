package sa.com.cloudsolutions.antikythera.testhelper.antipatterns;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Anti-pattern: Using TestRestTemplate or LocalServerPort without RANDOM_PORT.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UnsafeIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    public void testIntegration() {
        // test
    }
}
