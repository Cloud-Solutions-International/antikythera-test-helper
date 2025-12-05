package sa.com.cloudsolutions.antikythera.testhelper.antipatterns;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.data.jpa.repository.JpaRepository;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Anti-pattern: Using @SpringBootTest for repository testing instead
 * of @DataJpaTest.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InefficientRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testRepository() {
        userRepository.findAll();
    }

    interface UserRepository extends JpaRepository<User, Long> {
    }

    @Entity
    class User {
        @Id
        Long id;
    }
}
