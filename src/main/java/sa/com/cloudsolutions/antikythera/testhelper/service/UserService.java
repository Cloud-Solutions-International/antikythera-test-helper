package sa.com.cloudsolutions.antikythera.testhelper.service;

import sa.com.cloudsolutions.antikythera.testhelper.model.User;
import sa.com.cloudsolutions.antikythera.testhelper.repository.UserRepository;

import java.util.List;
import java.util.Optional;

/**
 * Service class for testing method call updates when repository method
 * signatures change.
 * This class has UserRepository as a field and calls various methods on it.
 */
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Find a user by username.
     * This method calls userRepository.findByUsername() which may be optimized.
     */
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    /**
     * Find a user by username using the @Query annotated method.
     * This method calls userRepository.findByUsernameWithQuery() which may be
     * optimized.
     */
    public User getUserByUsernameWithQuery(String username) {
        return userRepository.findByUsernameWithQuery(username);
    }

    /**
     * Find users by first name and last name.
     * This method calls userRepository.findByFirstNameAndLastName() which may have
     * parameters reordered.
     */
    public List<User> getUsersByName(String firstName, String lastName) {
        return userRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    /**
     * Find users by age.
     */
    public List<User> getUsersByAge(Integer age) {
        return userRepository.findByAge(age);
    }

    /**
     * Find user by username and age.
     */
    public Optional<User> getUserByUsernameAndAge(String username, Integer age) {
        return userRepository.findByUsernameAndAge(username, age);
    }

    /**
     * Multiple calls to the same method to test that all calls are updated.
     */
    public void processUsers(String firstName, String lastName) {
        // First call
        List<User> users1 = userRepository.findByFirstNameAndLastName(firstName, lastName);
        System.out.println("Found " + users1.size() + " users");

        // Second call with different arguments
        List<User> users2 = userRepository.findByFirstNameAndLastName("John", "Doe");
        System.out.println("Found " + users2.size() + " John Does");

        // Third call
        if (!userRepository.findByFirstNameAndLastName(firstName, lastName).isEmpty()) {
            System.out.println("Users exist");
        }
    }
}
