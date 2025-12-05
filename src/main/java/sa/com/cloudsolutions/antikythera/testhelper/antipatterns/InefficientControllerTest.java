package sa.com.cloudsolutions.antikythera.testhelper.antipatterns;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Anti-pattern: Using @SpringBootTest for controller testing instead
 * of @WebMvcTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class InefficientControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SomeService someService;

    @Test
    public void testController() throws Exception {
        mockMvc.perform(get("/api/resource"))
                .andExpect(status().isOk());
    }

    interface SomeService {
    }
}
