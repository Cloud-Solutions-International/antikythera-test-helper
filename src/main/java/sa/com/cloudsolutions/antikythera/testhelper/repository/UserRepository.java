package sa.com.cloudsolutions.antikythera.testhelper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sa.com.cloudsolutions.antikythera.testhelper.model.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
    
    // Basic finder methods that match TestRepositoryParser patterns
    User findByUsername(String username);
    
    User findByEmail(String email);
    
    List<User> findByAge(Integer age);
    
    Optional<User> findByUsernameAndAge(String username, Integer age);
    
    User findFirstByEmailOrderByAge(String email);
    
    List<User> findByAgeGreaterThanAndUsernameContaining(Integer age, String username);
    
    List<User> findByActiveAndDeleted(Boolean active, Boolean deleted);
    
    List<User> findByFirstNameAndLastName(String firstName, String lastName);
    
    List<User> findBySalaryGreaterThan(Long salary);
    
    List<User> findByMiddleNameIsNull();
    
    // Query annotation methods for testing @Query parsing
    @Query("SELECT u FROM User u WHERE u.username = ?1")
    User findByUsernameWithQuery(String username);
    
    @Query("SELECT u FROM User u WHERE u.username = ?1 AND u.age = ?2")
    User findByUsernameAndAgeWithQuery(String username, Integer age);
    
    @Query("SELECT u FROM User u WHERE u.active = true AND u.deleted = false")
    List<User> findActiveUsers();
    
    // Complex query for testing CASE expression conversion
    @Query("SELECT u, CASE WHEN u.balanceAmount > 0 THEN COALESCE(u.balanceAmount, 0) ELSE 0 END FROM User u")
    List<Object[]> findUsersWithBalanceCalculation();
    
    // Native query for testing native SQL parsing
    @Query(value = "SELECT * FROM test_users WHERE username = ?1", nativeQuery = true)
    User findByUsernameNative(String username);
    
    // Count methods
    Long countByActive(Boolean active);
    
    Long countByAgeGreaterThan(Integer age);
    
    // Exists methods
    Boolean existsByUsername(String username);
    
    Boolean existsByEmail(String email);
    
    // Delete methods
    void deleteByUsername(String username);
    
    Long deleteByAgeGreaterThan(Integer age);
}