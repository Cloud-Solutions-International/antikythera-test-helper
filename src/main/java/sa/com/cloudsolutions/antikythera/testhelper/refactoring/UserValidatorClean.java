package sa.com.cloudsolutions.antikythera.testhelper.refactoring;

/**
 * Clean version of UserValidator with extracted parameterized helper.
 * This is the expected result after refactoring UserValidatorDup.
 */
public class UserValidatorClean {

    private boolean validateCredentials(String name, String email) {
        if (name == null || name.isEmpty()) {
            return false;
        }
        if (email == null || !email.contains("@")) {
            return false;
        }
        return true;
    }

    public boolean validateAdmin(String name, String email) {
        return validateCredentials(name, email);
    }

    public boolean validateUser(String username, String emailAddr) {
        return validateCredentials(username, emailAddr);
    }

    public boolean validateGuest(String guestName, String guestEmail) {
        return validateCredentials(guestName, guestEmail);
    }
}
